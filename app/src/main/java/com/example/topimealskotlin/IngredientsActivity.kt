package com.example.topimealskotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.topimealskotlin.adapter.IngredientsAdapter
import com.example.topimealskotlin.model.Meal

open class IngredientsActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<String>

    lateinit var meal : Meal
    lateinit var strArea : TextView
    lateinit var strInstructions : TextView
    lateinit var strMeal : TextView
    lateinit var ingredientsListView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        initialeVariables()
        setupViews()
        setupAdapterAndList()
    }

    private fun initialeVariables() {
        meal = intent.getSerializableExtra(Companion.MEAL) as Meal
        strArea = findViewById(R.id.strAreaView)
        strInstructions = findViewById(R.id.strInstructionsView)
        strMeal = findViewById(R.id.strMealView)
        ingredientsListView = findViewById(R.id.ingredientsListView)
    }

    private fun setupAdapterAndList() {
        adapter = IngredientsAdapter().Adapter(applicationContext, meal)
        ingredientsListView.adapter = adapter
    }

    fun setupViews(){
        strMeal.text = meal.strMeal
        strArea.text = meal.strArea
        strInstructions.text = meal.strInstructions
    }

    companion object {
        fun startActivity(meal: Meal, context: Context) {
            val intent = Intent(context, IngredientsActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(MEAL, meal)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

        const val MEAL = "IngredientsActivity.meal"
    }

}