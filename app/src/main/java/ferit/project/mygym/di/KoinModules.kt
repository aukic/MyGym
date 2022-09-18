package ferit.project.mygym.di

import android.app.Application
import ferit.project.mygym.data.TrainingDao
import ferit.project.mygym.data.TrainingRepository
import ferit.project.mygym.data.TrainingRepositoryImpl
import ferit.project.mygym.data.room.TrainingDatabase
import ferit.project.mygym.ui.newtraining.NewTrainingViewModel
import ferit.project.mygym.ui.training.TrainingListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): TrainingDatabase {
        return TrainingDatabase.getDatabase(application)
    }
    fun provideTaskDao(database: TrainingDatabase): TrainingDao{
        return database.getTrainingDao()
    }
    single<TrainingDatabase> { provideDatabase(get()) }
    single<TrainingDao> { provideTaskDao(get()) }
}

val repositoryModule = module {
    single<TrainingRepository> { TrainingRepositoryImpl(get()) }
}

val viewmodelModule = module {
    viewModel { NewTrainingViewModel(get())  }
    viewModel { TrainingListViewModel(get())  }
}