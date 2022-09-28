package com.example.knowledgeimprovement.clean_architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.knowledgeimprovement.ApiInterface
import com.example.knowledgeimprovement.R
import com.example.knowledgeimprovement.RetrofitClient
import com.example.knowledgeimprovement.databinding.FragmentBinding

class CleanArchitectureFragment : Fragment(R.layout.fragment) {
    private var _binding: FragmentBinding? = null
    private val binding get() = _binding!!

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
        with(binding){
            btNextFragment.setOnClickListener {
                findNavController().navigate(R.id.action_cleanArchitectureFragment_to_MVIFragment)
            }
            tvFragmentType.text = getString(R.string.clean_architecture)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}