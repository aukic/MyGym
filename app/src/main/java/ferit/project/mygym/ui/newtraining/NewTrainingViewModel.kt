package ferit.project.mygym.ui.newtraining

import androidx.lifecycle.ViewModel
import ferit.project.mygym.data.TrainingRepository
import ferit.project.mygym.model.Training
import java.util.*
import kotlin.collections.ArrayList

class NewTrainingViewModel(
    val trainingRepository: TrainingRepository
): ViewModel(){
    fun save(date:Date, group:String, exercises: ArrayList<String>){
        trainingRepository.save(Training(0,date,group,exercises))
    }
}