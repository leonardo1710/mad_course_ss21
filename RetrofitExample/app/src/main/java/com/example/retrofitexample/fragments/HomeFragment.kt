package com.example.retrofitexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.retrofitexample.R
import com.example.retrofitexample.databinding.FragmentHomeBinding
import com.example.retrofitexample.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create a binding object
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Pass data to the binding object
        binding.viewModel = viewModel
        // Set the lifecycleOwner to update the layout.xml automatically when liveData is set - eg api request resolved
        binding.lifecycleOwner = viewLifecycleOwner

        // Observe the LiveData from ViewModel
        viewModel.randomJoke.observe(viewLifecycleOwner, { joke ->
            if (joke != null){
                // data loaded successfully
            }
        })

        binding.newJokeBtn.setOnClickListener {
            viewModel.getNewRandomJoke()
        }

        return binding.root
    }
}