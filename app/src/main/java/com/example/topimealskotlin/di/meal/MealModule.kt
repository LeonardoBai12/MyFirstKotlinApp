package com.example.topimealskotlin.di.meal

import com.example.topimealskotlin.network.meal.MealRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MealModule {
    @Provides
    fun providesMealRepository(retrofit: Retrofit) : MealRepository{
        return retrofit.create(MealRepository::class.java)
    }
}