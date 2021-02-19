package com.example.topimealskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.topimealskotlin.R
import com.example.topimealskotlin.model.Meal


class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MyViewHolder>() {

    private lateinit var mealsListFull: List<Meal>
    private var mealsList = emptyList<Meal>()
    private val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_meal, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val meal = mealsList[position]

        holder.strMeal.text = meal.strMeal
        holder.strArea.text = meal.strArea

        Glide.with(holder.itemView.context).load(meal.strMealThumb).centerCrop()
            .apply(requestOptions).into(holder.strMealThumb)

    }

    override fun getItemCount(): Int {
        if (!(this.mealsList.size == null))
            return this.mealsList.size
        else
            return 0
    }

    fun updateList(mealsList: List<Meal>){
        this.mealsList = mealsList
        notifyDataSetChanged()
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
