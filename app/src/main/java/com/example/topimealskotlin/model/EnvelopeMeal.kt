package com.example.topimealskotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EnvelopeMeal {
    @SerializedName("meals")
    @Expose
    private lateinit var mealList: List<Meal>

    fun getMealList(): List<Meal> {
        return mealList
    }

    fun setMealList(mealList: List<Meal>) {
        this.mealList = mealList
    }
}