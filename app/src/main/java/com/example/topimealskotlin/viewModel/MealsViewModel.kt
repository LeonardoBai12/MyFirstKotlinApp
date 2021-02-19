package com.example.topimealskotlin.viewModel

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topimealskotlin.model.EnvelopeMeal
import com.example.topimealskotlin.model.Meal
import com.example.topimealskotlin.network.MealApiService
import com.example.topimealskotlin.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsViewModel : ViewModel() {

    private val FILTER = "Chicken"

    fun loadMealsList(appContext: Context): MutableLiveData<List<Meal>> {
        var mealList: MutableLiveData<List<Meal>> = MutableLiveData<List<Meal>>()

        val service: MealApiService = RetrofitClientInstance().getRetrofitInstance()
            .create(MealApiService::class.java)
        val call: Call<EnvelopeMeal> = service.getMeals(FILTER)
        call.enqueue(object : Callback<EnvelopeMeal> {
            override fun onResponse(call: Call<EnvelopeMeal>, response: Response<EnvelopeMeal>) {
                mealList.value = response.body()?.getMealList()
            }

            override fun onFailure(call: Call<EnvelopeMeal>, t: Throwable) {
                Toast.makeText(appContext, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()
            }
        })
        return mealList;
    }


}
