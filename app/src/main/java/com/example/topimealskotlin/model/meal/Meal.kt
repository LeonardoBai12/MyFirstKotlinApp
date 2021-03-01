package com.example.topimealskotlin.model.meal

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meal( @field:SerializedName("idMeal")
                 var idMeal: String,

                 @field:SerializedName("strMeal")
                 var strMeal: String,

                 @field:SerializedName("strArea")
                 var strArea: String,

                 @field:SerializedName("strInstructions")
                 var strInstructions: String,

                 @field:SerializedName("strMealThumb")
                 var strMealThumb: String,

                 @field:SerializedName("strYoutube")
                 var strYoutube: String,

                 @field:SerializedName("strIngredient1")
                 var strIngredient1: String? = "",

                 @field:SerializedName("strIngredient2")
                 var strIngredient2: String? = "",

                 @field:SerializedName("strIngredient3")
                 var strIngredient3: String? = "",

                 @field:SerializedName("strIngredient4")
                 var strIngredient4: String? = "",

                 @field:SerializedName("strIngredient5")
                 var strIngredient5: String? = "",

                 @field:SerializedName("strIngredient6")
                 var strIngredient6: String? = "",

                 @field:SerializedName("strIngredient7")
                 var strIngredient7: String? = "",

                 @field:SerializedName("strIngredient8")
                 var strIngredient8: String? = "",

                 @field:SerializedName("strIngredient9")
                 var strIngredient9: String? = "",

                 @field:SerializedName("strIngredient10")
                 var strIngredient10: String? = "",

                 @field:SerializedName("strIngredient11")
                 var strIngredient11: String? = "",

                 @field:SerializedName("strIngredient12")
                 var strIngredient12: String? = "",

                 @field:SerializedName("strIngredient13")
                 var strIngredient13: String? = "",

                 @field:SerializedName("strIngredient14")
                 var strIngredient14: String? = "",

                 @field:SerializedName("strIngredient15")
                 var strIngredient15: String? = "",

                 @field:SerializedName("strIngredient16")
                 var strIngredient16: String? = "",

                 @field:SerializedName("strIngredient17")
                 var strIngredient17: String? = "",

                 @field:SerializedName("strIngredient18")
                 var strIngredient18: String? = "",

                 @field:SerializedName("strIngredient19")
                 var strIngredient19: String? = "",

                 @field:SerializedName("strIngredient20")
                 var strIngredient20: String? = "" ) : Serializable {
}