package com.example.topimealskotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.topimealskotlin.adapter.IngredientsAdapter
import com.example.topimealskotlin.adapter.MealsAdapter
import com.example.topimealskotlin.model.Meal
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.Extra
import org.androidannotations.annotations.ViewById

@EActivity(R.layout.activity_ingredients)
open class IngredientsActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<String>

    @Extra(Companion.MEAL)
    lateinit var meal : Meal

    @ViewById(R.id.strAreaView)
    lateinit var strArea : TextView

    @ViewById(R.id.strInstructionsView)
    lateinit var strInstructions : TextView

    @ViewById(R.id.strMealView)
    lateinit var strMeal : TextView

    @ViewById(R.id.ingredientsListView)
    lateinit var ingredientsListView : ListView

    @AfterViews
    fun afterViews(){
        strMeal.text = meal.strMeal
        strArea.text = meal.strArea
        strInstructions.text = meal.strInstructions
        adapter = IngredientsAdapter().Adapter(applicationContext,meal)
        ingredientsListView.adapter = adapter
        //TODO CLEAN CODE
    }

    companion object {
        fun startActivity(meal: Meal, context: Context) {
            val intent = Intent(context, IngredientsActivity_::class.java)
            val bundle = Bundle()
            bundle.putSerializable(MEAL, meal)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

        const val MEAL = "IngredientsActivity.meal"
    }

}