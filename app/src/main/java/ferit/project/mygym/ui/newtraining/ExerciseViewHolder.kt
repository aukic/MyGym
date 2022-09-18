package ferit.project.mygym.ui.newtraining

import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import ferit.project.mygym.databinding.ItemExerciseBinding
import ferit.project.mygym.model.Exercise
import java.lang.StringBuilder

class ExerciseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    lateinit var myItemClickListener: ItemClickListener
    lateinit var etWeight: EditText
    lateinit var etReps : EditText
    fun bind(exercise:Exercise){
        val binding = ItemExerciseBinding.bind(itemView)
        binding.itemExerciseContent.text = exercise.title
        binding.myCheckBox.isChecked = exercise.isSelected
        etWeight = binding.etWeight
        etReps = binding.etReps
        binding.myCheckBox.setOnClickListener(this)
    }

    fun setItemClickListener(ic: ItemClickListener){
        this.myItemClickListener = ic
    }

    override fun onClick(p0: View?) {
        this.myItemClickListener.onItemClick(p0!!, layoutPosition)
    }

    interface ItemClickListener{
        fun onItemClick(v: View,pos:Int)
    }
}