package com.example.topimealskotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.topimealskotlin.adapter.MealsAdapter
import com.example.topimealskotlin.model.Meal
import com.example.topimealskotlin.viewModel.MealsViewModel

class MainActivity : AppCompatActivity()  {

    private lateinit var adapter : MealsAdapter
    private lateinit var viewModel : MealsViewModel
    private lateinit var recyclerView : RecyclerView
    //val swipeContainer = findViewById<SwipeRefreshLayout>(R.id.swipeContainer)
    //val searchItem = findViewById<MenuItem>(R.id.action_search)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createAdapter()
        createRecyclerView()
        setupViewModel()
    }

    fun createAdapter() {
        adapter = MealsAdapter()
    }

    fun createRecyclerView(){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayout.VERTICAL))
        recyclerView.setAdapter(adapter)
    }

    fun setupViewModel(){
        viewModel = ViewModelProvider(this)[MealsViewModel::class.java]
        viewModel.loadMealsList(this).observe(this,this::updateList)
    }

    fun updateList(mealList : List<Meal>){
        adapter.updateList(mealList)
    }

}