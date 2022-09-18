package ferit.project.mygym.ui.training

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ferit.project.mygym.databinding.FragmentTrainingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class TrainingFragment: Fragment() {
    lateinit var binding: FragmentTrainingBinding
    private lateinit var date: Date
    private lateinit var adapter : TrainingAdapter
    private val viewModel: TrainingListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingBinding.inflate(layoutInflater)

        setupRecyclerView()
        viewModel.trainings.observe(viewLifecycleOwner){
            if (it != null && it.isNotEmpty()){
                adapter.setTrainings(it)
            }
        }
        binding.fabAddTraining.setOnClickListener { addTraining() }
        return binding.root
    }

    private fun addTraining() {
        val action = TrainingFragmentDirections.actionTrainingFragmentToDatePickerFragment()
        findNavController().navigate(action)
    }

    private fun setupRecyclerView() {
        binding.taskListRvTasks.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = TrainingAdapter()
        binding.taskListRvTasks.adapter = adapter
    }
}