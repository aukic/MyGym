package ferit.project.mygym.ui.newtraining

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import ferit.project.mygym.R
import ferit.project.mygym.model.Exercise
import org.koin.core.component.getScopeId
import java.lang.StringBuilder

class ExerciseAdapter : RecyclerView.Adapter<ExerciseViewHolder>(){
    private val exercises = ArrayList<Exercise>()
    val checkedExercises = ArrayList<String>()
    val checkedReps = ArrayList<String>()
    val checkedWeight = ArrayList<String>()
    fun setExercise(exercises: List<Exercise>){
        this.exercises.clear()
        this.exercises.addAll(exercises)
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.bind(exercise)

        holder.setItemClickListener(object : ExerciseViewHolder.ItemClickListener{
            override fun onItemClick(v: View, pos: Int) {
                val myCheckBox = v as CheckBox
                val currentExercise = exercises[pos]
                currentExercise.reps = holder.etReps.text.toString()
                currentExercise.weight = holder.etWeight.text.toString()
                if(myCheckBox.isChecked){
                    currentExercise.isSelected = true
                    var stringBuilder: StringBuilder = StringBuilder()
                    stringBuilder.append(currentExercise.title)
                    stringBuilder.append(", Ponvljanja: ")
                    stringBuilder.append(currentExercise.reps)
                    stringBuilder.append(", Težina: ")
                    stringBuilder.append(currentExercise.weight)
                    checkedExercises.add(stringBuilder.toString())
                } else if (!myCheckBox.isChecked){
                    currentExercise.isSelected = false
                    var stringBuilder: StringBuilder = StringBuilder()
                    stringBuilder.append(currentExercise.title)
                    stringBuilder.append(", Ponvljanja: ")
                    stringBuilder.append(currentExercise.reps)
                    stringBuilder.append(", Težina: ")
                    stringBuilder.append(currentExercise.weight)
                    checkedExercises.remove(stringBuilder.toString())
                }
            }

        })
    }

    override fun getItemCount(): Int {
        return exercises.count()
    }
}