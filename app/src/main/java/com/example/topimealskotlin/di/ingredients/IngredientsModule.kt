package com.example.topimealskotlin.di.ingredients

import com.example.topimealskotlin.network.meal.MealRepository
import com.example.topimealskotlin.ui.ingredients.IngredientsAdapter
import com.example.topimealskotlin.ui.meal.MealsAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class IngredientsModule {
    @Provides
    fun providesIngredientsAdapter() : IngredientsAdapter {
        return IngredientsAdapter()
    }
}