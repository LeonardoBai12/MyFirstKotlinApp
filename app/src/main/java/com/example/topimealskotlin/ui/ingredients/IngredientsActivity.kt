package com.example.topimealskotlin.ui.ingredients

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.topimealskotlin.R
import com.example.topimealskotlin.model.meal.Meal
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class IngredientsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var requestOptions: RequestOptions

    @Inject
    lateinit var  glideInstance: RequestManager

    lateinit var adapter : ArrayAdapter<String>

    lateinit var meal : Meal
    lateinit var strArea : TextView
    lateinit var strInstructions : TextView
    lateinit var strMeal : TextView
    lateinit var ingredientsListView : ListView
    lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)
        initialeVariables()
        setupViews()
        setupAdapterAndList()
    }

    private fun initialeVariables() {
        meal = intent.getSerializableExtra(MEAL) as Meal
        strArea = findViewById(R.id.strAreaView)
        strInstructions = findViewById(R.id.strInstructionsView)
        strMeal = findViewById(R.id.strMealView)
        imageView = findViewById(R.id.imageView2)
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
        glideInstance.load(meal.strMealThumb).centerCrop()
                .apply(requestOptions).into(imageView)
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