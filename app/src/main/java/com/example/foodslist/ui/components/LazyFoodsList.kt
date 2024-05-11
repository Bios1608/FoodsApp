package com.example.foodslist.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.example.foodslist.R
import com.example.foodslist.data.model.Food

@Composable
fun LazyFoodsList(
    foodsList: List<Food>,
    modifier: Modifier,
    detailNavigation:(Int)->Unit
){
    if (foodsList.isNotEmpty()){
        Box(modifier = modifier) {
            LazyColumn {
                items(foodsList, key = { it.id }) { food ->
                    FoodsItem(
                        modifier = modifier.testTag("lazy_list"),
                        id = food.id,
                        name = food.name,
                        shop = food.shop,
                        location = food.location,
                        photoUrl = food.photoUrl,
                        description = food.description,
                        detailNavigation = detailNavigation
                    )
                }
            }
        }
    } else {
        EmptyFoods(text = stringResource(R.string.empty_foods))
    }
}