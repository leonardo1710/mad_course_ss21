package com.example.databindingintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.databindingintro.databinding.FragmentHomeBottomBinding
import com.example.databindingintro.models.Song

class HomeBottomFragment : Fragment() {
    private lateinit var binding: FragmentHomeBottomBinding

    private var counter:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_bottom, container, false)

        binding.counterInBinding = counter

        binding.increaseCounterBtn.setOnClickListener {
            counter++
            binding.counterInBinding = counter
        }

        val song1 = Song("You never can tell", "Chuck Berry")
        val song2 = Song("Master of Puppets", "Metallica")
        var swapped = false

        binding.song = song1

        binding.swapBtn.setOnClickListener {
            when(swapped){
                true -> binding.song = song1
                false -> binding.song = song2
            }

            swapped = !swapped
        }



        return binding.root
    }
}