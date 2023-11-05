package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigation.databinding.FragmentFirstBinding



class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button1.setOnClickListener {
            val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            action.message = "Image 1"
            action.image = R.drawable.android_image_1

            Navigation.findNavController(it).navigate(action)
        }


        binding.button2.setOnClickListener {
            val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            action.message = "Image 2"
            action.image = R.drawable.android_image_2

            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val action: FirstFragmentDirections.ActionFirstFragmentToSecondFragment = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            action.message = "Image 3"
            action.image = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}