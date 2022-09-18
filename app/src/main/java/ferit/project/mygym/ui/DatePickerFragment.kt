package ferit.project.mygym.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ferit.project.mygym.databinding.FragmentDatePickerBinding
import java.util.*

class DatePickerFragment:Fragment() {
    private lateinit var binding: FragmentDatePickerBinding
    private lateinit var date: Date
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatePickerBinding.inflate(layoutInflater)

        var datePicker = binding.datePicker
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            date = Date(year-1900,month,day)
        }
        binding.btnTraining.setOnClickListener {
            val action = DatePickerFragmentDirections.actionDatePickerFragmentToNewTrainingFragment(date)
            findNavController().navigate(action)
        }
        return binding.root
    }
}