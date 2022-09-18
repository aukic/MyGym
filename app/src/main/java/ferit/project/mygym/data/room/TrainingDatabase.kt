package ferit.project.mygym.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ferit.project.mygym.data.TrainingDao
import ferit.project.mygym.model.Training

@Database(
    entities = [Training::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TrainingConverters::class)
abstract class TrainingDatabase:RoomDatabase() {
    abstract fun getTrainingDao(): TrainingDao

    companion object{
        private const val databaseName = "notesDb"

        @Volatile
        private var INSTANCE:TrainingDatabase? = null

        fun getDatabase(context: Context): TrainingDatabase{
            if(INSTANCE == null){
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }
        private fun buildDatabase(context: Context): TrainingDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TrainingDatabase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}