package com.example.topimealskotlin

import android.app.SearchManager
import android.graphics.PorterDuff
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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
open class MainActivity : AppCompatActivity()  {

    private lateinit var adapter : MealsAdapter
    private lateinit var viewModel : MealsViewModel

    @ViewById(R.id.recyclerView)
    lateinit var recyclerView : RecyclerView

    @ViewById(R.id.swipeContainer)
    lateinit var swipeContainer : SwipeRefreshLayout

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
        val layoutManager = LinearLayoutManager(applicationContext)
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