package ferit.project.mygym.ui.training

import android.R
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import ferit.project.mygym.databinding.ItemTrainingBinding

import ferit.project.mygym.model.Training
import java.text.SimpleDateFormat

class TrainingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    lateinit var arrayAdapter: ArrayAdapter<*>
    fun bind(training: Training){
        val binding = ItemTrainingBinding.bind(itemView)
        binding.tvGroup.text = training.exerciseGroup
        binding.tvDate.text = SimpleDateFormat("dd-MM-yyyy").format(training.dateOfTraining)
        if(training.exerciseList.isNullOrEmpty()){

        }else{
            var list: List<String> = training.exerciseList!!.toList()
            Log.i("LOG", list.toString())
            arrayAdapter = ArrayAdapter(itemView.context,
                R.layout.simple_list_item_1, list)
            binding.lvList.adapter = arrayAdapter
        }
    }
}