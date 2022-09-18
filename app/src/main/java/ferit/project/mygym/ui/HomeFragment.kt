package ferit.project.mygym.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ferit.project.mygym.R
import ferit.project.mygym.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnDiet.setOnClickListener { showDietFragment() }
        binding.btnTraining.setOnClickListener { showTrainingFragment() }
        binding.btnWeight.setOnClickListener {showWeightFragment()}
        return binding.root
    }

    private fun showWeightFragment() {
        val action = HomeFragmentDirections.actionHomeFragmentToWeightFragment()
        findNavController().navigate(action)
    }

    private fun showTrainingFragment() {
        val action = HomeFragmentDirections.actionHomeFragmentToTrainingFragment()
        findNavController().navigate(action)
    }

    private fun showDietFragment() {
        val action = HomeFragmentDirections.actionHomeFragmentToDietFragment()
        findNavController().navigate(action)
    }

}