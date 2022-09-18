package ferit.project.mygym.ui.training

import androidx.lifecycle.ViewModel
import ferit.project.mygym.data.TrainingRepository
import ferit.project.mygym.model.Training

class TrainingListViewModel (
    val trainingRepository: TrainingRepository
): ViewModel(){
    val trainings = trainingRepository.getAllTrainings()

    fun delete(training: Training){
        trainingRepository.delete(training)
    }
}