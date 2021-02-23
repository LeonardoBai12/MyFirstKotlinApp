package com.example.topimealskotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meal( @SerializedName("idMeal")
                 @Expose
                 var idMeal: String,

                 @SerializedName("strMeal")
                 @Expose
                 var strMeal: String,

                 @SerializedName("strArea")
                 @Expose
                 var strArea: String,

                 @SerializedName("strInstructions")
                 @Expose
                 var strInstructions: String,

                 @SerializedName("strMealThumb")
                 @Expose
                 var strMealThumb: String,

                 @SerializedName("strYoutube")
                 @Expose
                 var strYoutube: String,

                 @SerializedName("strIngredient1")
                 @Expose
                 var strIngredient1: String,

                 @SerializedName("strIngredient2")
                 @Expose
                 var strIngredient2: String,

                 @SerializedName("strIngredient3")
                 @Expose
                 var strIngredient3: String,

                 @SerializedName("strIngredient4")
                 @Expose
                 var strIngredient4: String,

                 @SerializedName("strIngredient5")
                 @Expose
                 var strIngredient5: String,

                 @SerializedName("strIngredient6")
                 @Expose
                 var strIngredient6: String,

                 @SerializedName("strIngredient7")
                 @Expose
                 var strIngredient7: String,

                 @SerializedName("strIngredient8")
                 @Expose
                 var strIngredient8: String,

                 @SerializedName("strIngredient9")
                 @Expose
                 var strIngredient9: String,

                 @SerializedName("strIngredient10")
                 @Expose
                 var strIngredient10: String,

                 @SerializedName("strIngredient11")
                 @Expose
                 var strIngredient11: String,

                 @SerializedName("strIngredient12")
                 @Expose
                 var strIngredient12: String,

                 @SerializedName("strIngredient13")
                 @Expose
                 var strIngredient13: String,

                 @SerializedName("strIngredient14")
                 @Expose
                 var strIngredient14: String,

                 @SerializedName("strIngredient15")
                 @Expose
                 var strIngredient15: String,

                 @SerializedName("strIngredient16")
                 @Expose
                 var strIngredient16: String,

                 @SerializedName("strIngredient17")
                 @Expose
                 var strIngredient17: String,

                 @SerializedName("strIngredient18")
                 @Expose
                 var strIngredient18: String,

                 @SerializedName("strIngredient19")
                 @Expose
                 var strIngredient19: String,

                 @SerializedName("strIngredient20")
                 @Expose
                 var strIngredient20: String
) : Serializable {
}