package ferit.project.mygym.data

import androidx.lifecycle.LiveData
import ferit.project.mygym.model.Training

interface TrainingRepository {
    fun save(task: Training)
    fun delete(task: Training)
    fun getAllTrainings(): LiveData<List<Training>>
}