package ferit.project.mygym.data

import androidx.lifecycle.LiveData
import ferit.project.mygym.model.Training

class TrainingRepositoryImpl(val trainingDao: TrainingDao): TrainingRepository {
    override fun save(task: Training) = trainingDao.save(task)

    override fun delete(task: Training) = trainingDao.delete(task)

    override fun getAllTrainings(): LiveData<List<Training>> = trainingDao.getAllTrainings()

}