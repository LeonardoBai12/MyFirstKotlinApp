package com.example.topimealskotlin.ui.meal

import android.app.SearchManager
import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.topimealskotlin.R
import com.example.topimealskotlin.model.meal.Meal
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MealActivity : DaggerAppCompatActivity() {

    private lateinit var adapter : MealsAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mealsViewModel: MealsViewModel by viewModels {
        viewModelFactory
    }

    lateinit var recyclerView : RecyclerView
    lateinit var swipeContainer : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializaVariables()
        createAdapter()
        createRecyclerView()
        setupViewModel()
        createRecyclerViewSwipe()
    }

    private fun initializaVariables() {
        swipeContainer = findViewById(R.id.swipeContainer)
        recyclerView = findViewById(R.id.recyclerView)
    }

    fun createAdapter() {
        adapter = MealsAdapter()
    }

    fun createRecyclerView(){
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayout.VERTICAL))
        recyclerView.setAdapter(adapter)
    }

    fun setupViewModel(){
        mealsViewModel.loadMealsList().observe(this, this::updateList)
    }

    fun updateList(mealList: List<Meal>){
        adapter.updateList(mealList)
    }

    fun createRecyclerViewSwipe() {
        swipeContainer.setOnRefreshListener(OnRefreshListener {
            mealsViewModel.loadMealsList()
            swipeContainer.setRefreshing(false)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.meals_menu, menu)

        val drawable = menu.getItem(0).icon
        drawable.mutate()

        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        val search = menu.findItem(R.id.action_search)
        val searchView = search.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)

        val textChangeListener: SearchView.OnQueryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String): Boolean {
                adapter.getFilter().filter(query)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                adapter.getFilter().filter(query)
                return true
            }
        }
        searchView.setOnQueryTextListener(textChangeListener)

        return super.onCreateOptionsMenu(menu)
    }

}