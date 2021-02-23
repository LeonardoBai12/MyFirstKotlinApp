package com.example.topimealskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.topimealskotlin.IngredientsActivity
import com.example.topimealskotlin.R
import com.example.topimealskotlin.model.Meal
import java.util.*


class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MyViewHolder>() {

    private var mealsListFull = emptyList<Meal>()
    private var mealsList = emptyList<Meal>()
    private val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_meal, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val meal = mealsList[position]

        holder.strMeal.text = meal.strMeal
        holder.strArea.text = meal.strArea

        holder.itemView.setOnClickListener{
            IngredientsActivity.startActivity(meal, holder.itemView.context)
        }

        Glide.with(holder.itemView.context).load(meal.strMealThumb).centerCrop()
            .apply(requestOptions).into(holder.strMealThumb)

    }

    override fun getItemCount(): Int {
        return this.mealsList.size
    }

    fun updateList(mealsList: List<Meal>){
        this.mealsList = mealsList
        this.mealsListFull = mealsList
        notifyDataSetChanged()
    }

    fun getFilter(): Filter {

        val filter : Filter

        filter = object : Filter(){
            override fun performFiltering(filter: CharSequence): FilterResults {
                var filter: CharSequence = filter
                val results = FilterResults()
                if (filter.length == 0) {
                    results.count = mealsListFull.size
                    results.values = mealsListFull
                } else {
                    val filteredItems: MutableList<Meal> = ArrayList<Meal>()
                    for (i in mealsListFull.indices) {
                        val data: Meal = mealsListFull.get(i)
                        filter = filter.toString().toLowerCase(Locale.ROOT)
                        val name = data.strMeal.toLowerCase(Locale.ROOT)
                        val area = data.strArea.toLowerCase(Locale.ROOT)
                        if (name.contains(filter) || area.contains(filter)) {
                            filteredItems.add(data)
                        }
                    }
                    results.count = filteredItems.size
                    results.values = filteredItems
                }
                return results
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                mealsList = results.values as List<Meal>
                notifyDataSetChanged()
            }

        }
        return filter
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.strMeal)
        lateinit var strMeal: TextView

        @BindView(R.id.strArea)
        lateinit var strArea: TextView

        @BindView(R.id.strMealThumb)
        lateinit var strMealThumb : ImageView

        init {
            ButterKnife.bind(this, itemView)
        }
    }

}
