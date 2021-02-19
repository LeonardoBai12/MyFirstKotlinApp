package com.example.topimealskotlin

import android.app.ProgressDialog
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.topimealskotlin.adapter.MealsAdapter
import com.example.topimealskotlin.model.Meal
import com.example.topimealskotlin.viewModel.MealsViewModel
import org.androidannotations.annotations.*

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.meals_menu)
open class MainActivity : AppCompatActivity()  {

    private lateinit var adapter : MealsAdapter
    private lateinit var viewModel : MealsViewModel

    @ViewById(R.id.recyclerView)
    lateinit var recyclerView : RecyclerView

    @ViewById(R.id.swipeContainer)
    lateinit var swipeContainer : SwipeRefreshLayout

    @OptionsMenuItem(R.id.action_search)
    lateinit var searchItem : MenuItem

    @AfterViews
    fun afterViews() {
        createAdapter()
        createRecyclerView()
        setupViewModel()
        createRecyclerViewSwipe()
    }

    fun createAdapter() {
        adapter = MealsAdapter()
    }

    fun createRecyclerView(){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayout.VERTICAL))
        recyclerView.setAdapter(adapter)
    }

    fun setupViewModel(){
        viewModel = ViewModelProvider(this)[MealsViewModel::class.java]
        viewModel.loadMealsList(this).observe(this, this::updateList)
    }

    fun updateList(mealList: List<Meal>){
        adapter.updateList(mealList)
    }

    fun createRecyclerViewSwipe() {
        swipeContainer.setOnRefreshListener(OnRefreshListener {
            viewModel.loadMealsList(applicationContext)
            swipeContainer.setRefreshing(false)
        })
    }

}