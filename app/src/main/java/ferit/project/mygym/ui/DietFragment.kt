package ferit.project.mygym.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import ferit.project.mygym.R
import ferit.project.mygym.databinding.FragmentDietBinding

class DietFragment : Fragment() {

    private lateinit var binding: FragmentDietBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDietBinding.inflate(layoutInflater)

        binding.tvAmount.text = "0"
        binding.tvCaloriesAmount.text = "0"
        binding.clGoal.setOnClickListener{ setGoal()}
        binding.clCaloriesInput.setOnClickListener{ setCalories()}
        return binding.root
    }

    private fun setGoal() {
        var goal = EditText(context)
        goal.inputType = InputType.TYPE_CLASS_PHONE
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Cilj")
        builder.setMessage("Unesite željeni iznos kalorija za jedan dan")
        builder.setView(goal)
        builder.setPositiveButton("Unesi"){dialog,which ->
            if(goal.text.toString().isNotEmpty()){
                binding.tvAmount.text = goal.text.toString()
                var goalCalories = binding.tvAmount.text.toString().toInt()
                var caloriesAmount = binding.tvCaloriesAmount.text.toString().toInt()

                if(goalCalories - caloriesAmount <= 0) {
                    binding.tvCaloriesAmountLeft.text = "0"
                }else{
                    binding.tvCaloriesAmountLeft.text = (goalCalories - caloriesAmount).toString()
                }
            }
        }
        builder.setNegativeButton("Poništi"){dialog,which ->

        }
        builder.show()
    }

    private fun setCalories() {
        var goalCalories = binding.tvAmount.text.toString().toInt()

        var consumedCalories = EditText(context)
        consumedCalories.inputType = InputType.TYPE_CLASS_PHONE
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Unešene kalorije")
        builder.setMessage("Unesite unešene kalorije za danas")
        builder.setView(consumedCalories)
        builder.setPositiveButton("Unesi"){dialog,which ->
            if (consumedCalories.text.toString().isNotEmpty()){
                binding.tvCaloriesAmount.text = consumedCalories.text.toString()
                var caloriesAmount = binding.tvCaloriesAmount.text.toString().toInt()

                if(goalCalories - caloriesAmount <= 0) {
                    binding.tvCaloriesAmountLeft.text = "0"
                }else{
                    binding.tvCaloriesAmountLeft.text = (goalCalories - caloriesAmount).toString()
                }
            }
        }
        builder.setNegativeButton("Poništi"){dialog,which ->

        }
        builder.show()
    }
}