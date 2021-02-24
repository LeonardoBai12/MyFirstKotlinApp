package com.example.topimealskotlin.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topimealskotlin.model.Meal
import com.example.topimealskotlin.model.MealConstants
import com.example.topimealskotlin.network.MealRepository
import com.example.topimealskotlin.network.RetrofitClientInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MealsViewModel : ViewModel() {

    fun loadMealsList(appContext: Context): MutableLiveData<List<Meal>> {
        val mealList = MutableLiveData<List<Meal>>()
        val repository = RetrofitClientInstance()
        //val call = repository.getMeals(FILTER)

        CoroutineScope(IO).launch {
            val res = repository.getMeals()

            if(res.isSuccessful){
                withContext(Dispatchers.Main){
                    mealList.value = res.body()?.getMealList()
                }
            }
        }
        return mealList;
    }


}
