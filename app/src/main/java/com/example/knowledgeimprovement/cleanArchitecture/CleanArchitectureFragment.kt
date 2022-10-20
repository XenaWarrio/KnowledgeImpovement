package com.example.knowledgeimprovement.cleanArchitecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.knowledgeimprovement.MoviesAdapter
import com.example.knowledgeimprovement.R
import com.example.knowledgeimprovement.app.KnowledgeImprovementApp
import com.example.knowledgeimprovement.databinding.FragmentBinding
import com.example.knowledgeimprovement.utils.toMovieDomainModel

class CleanArchitectureFragment : Fragment(R.layout.fragment) {
    private var _binding: FragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { MoviesAdapter() }

    private val viewModel: CleanArchitectureViewModel by viewModels {
        CleanArchitectureViewModelFactory(
            (requireActivity().application as KnowledgeImprovementApp).useCases
        )
    }

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
            recycler.apply {
                adapter = adapter
                hasFixedSize()
            }
            btNextFragment.setOnClickListener {
                findNavController().navigate(R.id.action_cleanArchitectureFragment_to_MVIFragment)
            }
            tvFragmentType.text = getString(R.string.clean_architecture)
        }
    }

    private fun setObservers() {
        viewModel.movies.observe(viewLifecycleOwner) { movieList ->
            adapter.addMovies(movieList.map { it.toMovieDomainModel() })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}