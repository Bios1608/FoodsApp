package com.example.foodslist.data.repository

import com.example.foodslist.data.model.Food
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    fun getFoodsData():Flow<List<Food>>

    fun searchFoodData(keyword:String):Flow<List<Food>>

    fun getFavoriteFoodsData():Flow<List<Food>>

    fun getDetailsFromFood(foodId:Int):Flow<Food>
}