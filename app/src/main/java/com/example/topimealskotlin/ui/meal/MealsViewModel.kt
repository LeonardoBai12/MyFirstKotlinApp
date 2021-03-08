package com.example.topimealskotlin.ui.meal

import android.app.Dialog
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topimealskotlin.model.meal.Meal
import com.example.topimealskotlin.model.meal.MealConstants
import com.example.topimealskotlin.network.meal.MealRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class MealsViewModel @Inject constructor( private val repository: MealRepository) : ViewModel() {

    fun loadMealsList(dialog: Dialog): MutableLiveData<List<Meal>> {
        val mealList = MutableLiveData<List<Meal>>()

        dialog.show()

        CoroutineScope(IO).launch {
            val res = repository.getMeals(MealConstants.FILTER)

            if(res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    mealList.value = res.body()?.getMealList()
                }
            }

        }
        return mealList
    }


}
