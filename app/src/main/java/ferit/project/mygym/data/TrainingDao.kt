package ferit.project.mygym.data

import androidx.lifecycle.LiveData
import androidx.room.*
import ferit.project.mygym.model.Training

@Dao
interface TrainingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(training: Training)

    @Delete
    fun delete(training: Training)

    @Query("SELECT * FROM trainings")
    fun getAllTrainings(): LiveData<List<Training>>
}