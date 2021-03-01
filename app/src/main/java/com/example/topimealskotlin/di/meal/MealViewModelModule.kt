package com.example.topimealskotlin.di.meal

import androidx.lifecycle.ViewModel
import com.example.topimealskotlin.di.ViewModelKey
import com.example.topimealskotlin.ui.meal.MealsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MealViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MealsViewModel::class)
    abstract fun bindMealsViewModel(viewModel: MealsViewModel) : ViewModel

}