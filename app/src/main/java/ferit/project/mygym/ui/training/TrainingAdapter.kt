package ferit.project.mygym.ui.training

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import ferit.project.mygym.R
import ferit.project.mygym.model.Training

class TrainingAdapter:RecyclerView.Adapter<TrainingViewHolder> (){
    private val trainings = mutableListOf<Training>()
    fun setTrainings(trainings: List<Training>){
        this.trainings.clear()
        this.trainings.addAll(trainings)
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_training,parent,false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val training = trainings[position]
        holder.bind(training)
    }

    override fun getItemCount(): Int {
        return trainings.count()
    }
}