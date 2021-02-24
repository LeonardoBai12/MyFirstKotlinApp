package com.example.topimealskotlin.network

import com.example.topimealskotlin.model.EnvelopeMeal
import com.example.topimealskotlin.model.Meal
import com.example.topimealskotlin.model.MealConstants
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    private val api : MealRepository = Retrofit.Builder().baseUrl(MealConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(MealRepository::class.java)
    @SerializedName("meals")
    suspend fun getMeals() : Response<EnvelopeMeal> = api.getMeals(MealConstants.FILTER)

}