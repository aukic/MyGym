package ferit.project.mygym

import android.app.Application
import ferit.project.mygym.di.databaseModule
import ferit.project.mygym.di.repositoryModule
import ferit.project.mygym.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyGym:Application() {

    override fun onCreate() {
        super.onCreate()
        application = this

        startKoin {
            androidLogger( if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MyGym)
            modules(
                databaseModule,
                repositoryModule,
                viewmodelModule
            )
        }
    }

    companion object{
        lateinit var application: Application
    }
}