package dev.jakubzika.worktracker.di

import android.content.Context
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

// Koin module for persistence

const val PREFERENCES_FILE_KEY = "cz.twisto.app.SHARED_PREFS"

val persistenceModule = module {

    single { androidApplication().getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE) }
}