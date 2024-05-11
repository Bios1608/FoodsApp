package com.example.foodslist.ui.pages.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.foodslist.ui.components.LazyFoodsList
import com.example.foodslist.ui.components.LazyGridList
import com.example.foodslist.utils.State

@Composable
fun FavoritesPage(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    detailNavigation:(Int)->Unit
) {
    viewModel.foodList.collectAsState(initial = State.Loading).value.let { foodListState ->
        when (foodListState) {
            is State.Loading -> {
                viewModel.getFavoriteFoods()
            }

            is State.Error -> {
            }

            is State.Success -> {
                LazyGridList(foodsList = foodListState.data, modifier = modifier, detailNavigation = detailNavigation)
            }
        }
    }
}
