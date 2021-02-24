package com.example.topimealskotlin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meal( @SerializedName("idMeal")
                 var idMeal: String,

                 @SerializedName("strMeal")
                 var strMeal: String,

                 @SerializedName("strArea")
                 var strArea: String,

                 @SerializedName("strInstructions")
                 var strInstructions: String,

                 @SerializedName("strMealThumb")
                 var strMealThumb: String,

                 @SerializedName("strYoutube")
                 var strYoutube: String,

                 @SerializedName("strIngredient1")
                 var strIngredient1: String,

                 @SerializedName("strIngredient2")
                 var strIngredient2: String,

                 @SerializedName("strIngredient3")
                 var strIngredient3: String,

                 @SerializedName("strIngredient4")
                 var strIngredient4: String,

                 @SerializedName("strIngredient5")
                 var strIngredient5: String,

                 @SerializedName("strIngredient6")
                 var strIngredient6: String,

                 @SerializedName("strIngredient7")
                 var strIngredient7: String,

                 @SerializedName("strIngredient8")
                 var strIngredient8: String,

                 @SerializedName("strIngredient9")
                 var strIngredient9: String,

                 @SerializedName("strIngredient10")
                 var strIngredient10: String,

                 @SerializedName("strIngredient11")
                 var strIngredient11: String,

                 @SerializedName("strIngredient12")
                 var strIngredient12: String,

                 @SerializedName("strIngredient13")
                 var strIngredient13: String,

                 @SerializedName("strIngredient14")
                 var strIngredient14: String,

                 @SerializedName("strIngredient15")
                 var strIngredient15: String,

                 @SerializedName("strIngredient16")
                 var strIngredient16: String,

                 @SerializedName("strIngredient17")
                 var strIngredient17: String,

                 @SerializedName("strIngredient18")
                 var strIngredient18: String,

                 @SerializedName("strIngredient19")
                 var strIngredient19: String,

                 @SerializedName("strIngredient20")
                 var strIngredient20: String
) : Serializable {
}