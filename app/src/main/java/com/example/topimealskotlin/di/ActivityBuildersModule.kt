package com.example.topimealskotlin.di

import com.example.topimealskotlin.di.meal.MealModule
import com.example.topimealskotlin.di.meal.MealViewModelModule
import com.example.topimealskotlin.ui.ingredients.IngredientsActivity
import com.example.topimealskotlin.ui.meal.MealActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
            modules = [
                MealViewModelModule::class,
                MealModule::class
            ]
    )
    abstract fun contributeMealActivity() : MealActivity
}