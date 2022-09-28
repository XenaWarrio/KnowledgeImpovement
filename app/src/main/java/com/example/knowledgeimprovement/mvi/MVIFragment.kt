package com.example.knowledgeimprovement.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.knowledgeimprovement.MoviesAdapter
import com.example.knowledgeimprovement.R
import com.example.knowledgeimprovement.databinding.FragmentBinding
import kotlinx.coroutines.launch

class MVIFragment : Fragment(R.layout.fragment) {
    private var _binding: FragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MVIViewModel by viewModels()
    private val adapter by lazy { MoviesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sendIntent(MVIIntent.GetMovieList)
        setUpUi()
        setObservers()
    }

    private fun setUpUi() {
        with(binding) {
            recycler.adapter = adapter
            btNextFragment.setOnClickListener {
                findNavController().navigate(R.id.action_MVIFragment_to_MVVMFragment)
            }
            tvFragmentType.text = getString(R.string.mvi)
        }
    }

    private fun setObservers() {
        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    MVIState.InitialState -> {}
                    is MVIState.ListLoadedError -> Toast.makeText(
                        requireContext(),
                        it.error,
                        Toast.LENGTH_LONG
                    ).show()
                    is MVIState.ListLoadedSuccess -> adapter.addMovies(it.movies)
                    MVIState.Loading -> {}
                    MVIState.StopLoading -> {}
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}