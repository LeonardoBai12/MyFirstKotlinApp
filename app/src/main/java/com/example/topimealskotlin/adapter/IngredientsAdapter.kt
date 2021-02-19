package com.example.topimealskotlin.adapter

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import com.example.topimealskotlin.model.Meal
import java.util.*
import kotlin.collections.ArrayList

class IngredientsAdapter {

    lateinit var meal : Meal
    var ingredientsList = arrayListOf<String>()

    fun Adapter(appContext: Context, meal : Meal) : ArrayAdapter<String> {
        this.meal = meal
        populateIngredientList()
        return ArrayAdapter(appContext, R.layout.simple_list_item_1, R.id.text1, ingredientsList )
    }

    fun addIfNotEmptyOrNull(arrayList: ArrayList<String>, string: String) {
        if (string != null && !string.trim { it <= ' ' }.isEmpty()) {
            arrayList.add(string)
        }
    }

    fun populateIngredientList() {
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient1)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient2)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient3)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient4)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient5)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient6)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient7)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient8)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient9)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient10)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient11)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient12)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient13)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient14)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient15)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient16)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient17)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient18)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient19)
        addIfNotEmptyOrNull(ingredientsList, meal.strIngredient20)
    }

}