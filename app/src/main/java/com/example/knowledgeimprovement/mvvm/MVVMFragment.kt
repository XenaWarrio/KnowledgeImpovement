package com.example.knowledgeimprovement.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.knowledgeimprovement.MoviesAdapter
import com.example.knowledgeimprovement.R
import com.example.knowledgeimprovement.databinding.FragmentBinding

class MVVMFragment : Fragment(R.layout.fragment) {
    private var _binding: FragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { MoviesAdapter() }
    private val viewModel: MVVMViewModel by viewModels()

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

        setUpUi()
        setObservers()
    }

    private fun setUpUi() {
        with(binding) {
            recycler.adapter = adapter
            btNextFragment.setOnClickListener {
                findNavController().navigate(R.id.action_MVVMFragment_to_cleanArchitectureFragment)
            }
            tvFragmentType.text = getString(R.string.mvvm)
        }
    }

    private fun setObservers() {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.addMovies(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}