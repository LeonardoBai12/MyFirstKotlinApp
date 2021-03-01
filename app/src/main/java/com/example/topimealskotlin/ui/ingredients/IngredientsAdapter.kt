package com.example.topimealskotlin.ui.ingredients

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import com.example.topimealskotlin.model.meal.Meal
import kotlin.collections.ArrayList

class IngredientsAdapter {

    lateinit var meal : Meal
    var ingredientsList = arrayListOf<String>()

    fun Adapter(appContext: Context, meal : Meal) : ArrayAdapter<String> {
        this.meal = meal
        populateIngredientList()
        return ArrayAdapter(appContext, R.layout.simple_list_item_1, R.id.text1, ingredientsList )
    }

    fun addIfNotEmpty(arrayList: ArrayList<String>, string: String?) {
        if ((string != null) && string.trim { it <= ' ' }.isNotEmpty()) {
            arrayList.add(string)
        }
    }

    fun populateIngredientList() {
        addIfNotEmpty(ingredientsList, meal.strIngredient1)
        addIfNotEmpty(ingredientsList, meal.strIngredient2)
        addIfNotEmpty(ingredientsList, meal.strIngredient3)
        addIfNotEmpty(ingredientsList, meal.strIngredient4)
        addIfNotEmpty(ingredientsList, meal.strIngredient5)
        addIfNotEmpty(ingredientsList, meal.strIngredient6)
        addIfNotEmpty(ingredientsList, meal.strIngredient7)
        addIfNotEmpty(ingredientsList, meal.strIngredient8)
        addIfNotEmpty(ingredientsList, meal.strIngredient9)
        addIfNotEmpty(ingredientsList, meal.strIngredient10)
        addIfNotEmpty(ingredientsList, meal.strIngredient11)
        addIfNotEmpty(ingredientsList, meal.strIngredient12)
        addIfNotEmpty(ingredientsList, meal.strIngredient13)
        addIfNotEmpty(ingredientsList, meal.strIngredient14)
        addIfNotEmpty(ingredientsList, meal.strIngredient15)
        addIfNotEmpty(ingredientsList, meal.strIngredient16)
        addIfNotEmpty(ingredientsList, meal.strIngredient17)
        addIfNotEmpty(ingredientsList, meal.strIngredient18)
        addIfNotEmpty(ingredientsList, meal.strIngredient19)
        addIfNotEmpty(ingredientsList, meal.strIngredient20)
    }

}