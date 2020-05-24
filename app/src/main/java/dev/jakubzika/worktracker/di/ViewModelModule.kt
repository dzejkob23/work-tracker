package dev.jakubzika.worktracker.di

import dev.jakubzika.worktracker.viewmodel.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { TimerViewModel() }

}