package com.example.foodslist.data.repository

import com.example.foodslist.data.model.Food
import com.example.foodslist.data.model.FoodData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepositoryImpl @Inject constructor():FoodRepository {
    private val foodData = mutableListOf<Food>()

    override fun getFoodsData(): Flow<List<Food>> = flow{
        if (foodData.isEmpty()){
            foodData.addAll(FoodData.foodData)
        }
        emit(foodData)
    }

    override fun searchFoodData(keyword:String): Flow<List<Food>> = flow{
        if (foodData.isEmpty()){
            foodData.addAll(FoodData.foodData)
        }
        val result = foodData.filter {food->
            food.name.contains(keyword, ignoreCase = true)
        }
        emit(result)
    }

    override fun getFavoriteFoodsData(): Flow<List<Food>> = flow{
        emit(foodData.filter { food -> food.favorite })
    }

    override fun getDetailsFromFood(foodId: Int): Flow<Food> = flow{
        emit(foodData.first { food -> food.id==foodId })
    }

}