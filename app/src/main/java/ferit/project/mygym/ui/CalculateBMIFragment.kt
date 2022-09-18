package ferit.project.mygym.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ferit.project.mygym.databinding.FragmentCalculateBmiBinding

class CalculateBMIFragment:Fragment() {
    private lateinit var binding: FragmentCalculateBmiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBmiBinding.inflate(layoutInflater)
        
        binding.tvCalculateBMI.setOnClickListener { calculateBMI() }
        
        return binding.root
    }

    private fun calculateBMI() {
        if(binding.tvCurrentHeightAmount.text.isEmpty() || binding.tvCurrentWeightAmount.text.isEmpty()){
            Toast.makeText(context, "Unesite težinu i visinu", Toast.LENGTH_SHORT).show()
        } else {
            var weight = binding.tvCurrentWeightAmount.text.toString().toDouble()
            var height = binding.tvCurrentHeightAmount.text.toString().toDouble() / 100
            var bmi = String.format("%.2f",(weight / (height * height)))
            binding.tvBMIIndexAmount.text = bmi
        }
    }
}