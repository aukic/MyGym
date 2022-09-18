package ferit.project.mygym.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ferit.project.mygym.databinding.FragmentWeightBinding

class WeightFragment:Fragment() {
    private lateinit var binding:FragmentWeightBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeightBinding.inflate(layoutInflater)

        binding.tvAmount.text = "0"
        binding.tvLeftToGaolAmount.text = "0"
        binding.tvCurrentWeightAmount.text = "0"
        binding.clGoal.setOnClickListener{setGoal()}
        binding.clWeight.setOnClickListener { setWeight() }
        binding.tvCalculateBMI.setOnClickListener { showCalculateBmiFragment() }
        return binding.root
    }

    private fun showCalculateBmiFragment() {
        val action = WeightFragmentDirections.actionWeightFragmentToCalculateBMIFragment()
        findNavController().navigate(action)
    }

    private fun setWeight(){
        var weight = EditText(context)
        weight.inputType = InputType.TYPE_CLASS_PHONE
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Cilj")
        builder.setMessage("Unesite ciljanu kilažu")
        builder.setView(weight)
        builder.setPositiveButton("Unesi"){dialog,which ->
            if(weight.text.toString().isNotEmpty()){
                binding.tvCurrentWeightAmount.text = weight.text.toString()
                var gaolWeight = binding.tvAmount.text.toString().toInt()
                var currentWeight = binding.tvCurrentWeightAmount.text.toString().toInt()

                binding.tvLeftToGaolAmount.text = (gaolWeight - currentWeight).toString()

            }
        }
        builder.setNegativeButton("Poništi"){dialog,which ->

        }
        builder.show()
    }

    private fun setGoal() {
        var goal = EditText(context)
        goal.inputType = InputType.TYPE_CLASS_PHONE
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Cilj")
        builder.setMessage("Unesite ciljanu kilažu")
        builder.setView(goal)
        builder.setPositiveButton("Unesi"){dialog,which ->
            if(goal.text.toString().isNotEmpty()){
                binding.tvAmount.text = goal.text.toString()
                var gaolWeight = binding.tvAmount.text.toString().toInt()
                var currentWeight = binding.tvCurrentWeightAmount.text.toString().toInt()

                binding.tvLeftToGaolAmount.text = (gaolWeight - currentWeight).toString()

            }
        }
        builder.setNegativeButton("Poništi"){dialog,which ->

        }
        builder.show()
    }
}