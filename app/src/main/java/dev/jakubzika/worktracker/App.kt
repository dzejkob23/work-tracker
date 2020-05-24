package dev.jakubzika.worktracker

import android.content.Context
import androidx.multidex.MultiDexApplication
import dev.jakubzika.worktracker.di.persistenceModule
import dev.jakubzika.worktracker.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : MultiDexApplication() {

    companion object {

        lateinit var appContext: Context

    }

    override fun onCreate() {
        super.onCreate()

        // Save application context
        appContext = applicationContext

        // Start Koin
        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule,
                persistenceModule
            )
        }
    }

}