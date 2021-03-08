package com.example.topimealskotlin.di.meal

import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.topimealskotlin.network.meal.MealRepository
import com.example.topimealskotlin.ui.meal.MealsAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MealModule {
    @Provides
    fun providesMealsAdapter(requestOptions: RequestOptions,
                             glideInstance: RequestManager) : MealsAdapter{
        return MealsAdapter(requestOptions, glideInstance)
    }

    @Provides
    fun providesMealRepository(retrofit: Retrofit) : MealRepository{
        return retrofit.create(MealRepository::class.java)
    }
}