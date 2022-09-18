package ferit.project.mygym.ui.newtraining

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ferit.project.mygym.R
import ferit.project.mygym.databinding.FragmentNewTrainingBinding
import ferit.project.mygym.model.Exercise
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList


class NewTrainingFragment:Fragment() {
    lateinit var binding: FragmentNewTrainingBinding
    private lateinit var date: Date
    private lateinit var spinner: Spinner
    private lateinit var adapter: ExerciseAdapter
    private val viewModel: NewTrainingViewModel by viewModel()
    private var chestExercises :List<Exercise> = listOf(Exercise("Barbell Bench Press", null,null),Exercise( "Dumbbell Bench Press", null,null), Exercise("Incline Bench Press", null,null),Exercise( "Machine Chest Press", null,null), Exercise("Push-Up", null,null), Exercise("Dip", null,null))
    private var bicepsExercises :List<Exercise> = listOf(Exercise("Barbell Curl", null,null),Exercise( "Chin-Up", null,null),Exercise( "Hammer Curl", null,null), Exercise("Cable Burl", null,null), Exercise("Incline Dumbbell Curl", null,null), Exercise("Pull-Up", null,null))
    private var backExercises :List<Exercise> = listOf(Exercise("Lat Pulldown", null,null), Exercise("Back Extension", null,null), Exercise("Suspended Row", null,null), Exercise("Single-Arm Dumbbell Row", null,null), Exercise("Wide dumbbell bent-over row", null,null),Exercise( "Barbell deadlift", null,null))
    private var legExercises :List<Exercise> = listOf(Exercise("Back Squat", null,null), Exercise("Front Squat", null,null), Exercise("Romanian Deadlift", null,null), Exercise("Waling lunges", null,null), Exercise("Goblet squat", null,null), Exercise("Bulgarian split squat", null,null))
    private var tricepsExercises :List<Exercise> = listOf(Exercise("Diamond Push-Ups", null,null), Exercise("Triceps Kickbacks", null,null), Exercise("Triceps Dips", null,null), Exercise("Overhead Triceps Extensions", null,null), Exercise("Rope Pushdowns", null,null), Exercise("Lying Triceps Extensions", null,null))
    private var coreExercises :List<Exercise> = listOf(Exercise("HOLLOWMAN", null,null), Exercise("HIGH PLANK", null,null), Exercise("V-UPS", null,null), Exercise("PLANK KNEE CROSSES", null,null), Exercise("LEG RAISES", null,null), Exercise("LOW PLANK", null,null))
    private var emptyList = listOf<Exercise>()
    private var groupTitle = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewTrainingBinding.inflate(layoutInflater)

        date = NewTrainingFragmentArgs.fromBundle(requireArguments()).date

        setupRecyclerView()
        spinner = binding.spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.exercise,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position){
                    0 -> {
                        adapter.setExercise(chestExercises)
                        groupTitle = "Prsa"
                    }
                    1 -> {
                        adapter.setExercise(bicepsExercises)
                        groupTitle = "Biceps"
                    }
                    2 -> {
                        adapter.setExercise(backExercises)
                        groupTitle = "Leđa"
                    }
                    3 -> {
                        adapter.setExercise(legExercises)
                        groupTitle = "Noge"
                    }
                    4 -> {
                        adapter.setExercise(tricepsExercises)
                        groupTitle = "Triceps"
                    }
                    5 -> {
                        adapter.setExercise(coreExercises)
                        groupTitle = "Core"
                    }
                    6 -> {
                        adapter.setExercise(emptyList)
                        groupTitle = "Dan odmora"
                    }
                    else -> {
                        adapter.setExercise(emptyList)
                        groupTitle = "Dan odmora"
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            }

        binding.btnAdd.setOnClickListener { createTraining() }

        return binding.root
    }

    private fun createTraining() {
        var exercises = adapter.checkedExercises
        Log.i("LOG", date.toString())
        viewModel.save(date,groupTitle, exercises)

        val action = NewTrainingFragmentDirections.actionNewTrainingFragmentToTrainingFragment()
        findNavController().navigate(action)
    }

    private fun setupRecyclerView() {
        binding.exerciseListRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = ExerciseAdapter()
        binding.exerciseListRv.adapter = adapter
    }

}