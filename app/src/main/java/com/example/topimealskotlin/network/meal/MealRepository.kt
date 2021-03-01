package com.example.topimealskotlin.network.meal

import com.example.topimealskotlin.model.meal.EnvelopeMeal
import com.example.topimealskotlin.model.meal.MealConstants
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealRepository {
    @GET("api/json/v1/1/search.php")
    suspend fun getMeals(@Query("s") filter: String): Response<EnvelopeMeal>
}
