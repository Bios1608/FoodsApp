package com.example.foodslist.ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.foodslist.data.model.Food
import com.example.foodslist.ui.components.LazyChipList
import com.example.foodslist.ui.components.LazyFoodsList
import com.example.foodslist.ui.components.SearchBar
import com.example.foodslist.utils.State

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    detailNavigation: (Int) -> Unit,
) {
    val searchKeyword by viewModel.searchKeyword
    viewModel.foodList.collectAsState(initial = State.Loading).value.let { state ->
        when (state) {
            is State.Loading -> {
                viewModel.search(searchKeyword)
            }

            is State.Error -> {
            }

            is State.Success -> {
                HomeBody(
                    modifier = modifier,
                    keyword = searchKeyword,
                    onKeywordChange = viewModel::search,
                    listFoods = state.data,
                    detailNavigation = detailNavigation
                )
            }
        }
    }
}

@Composable
fun HomeBody(
    modifier: Modifier,
    keyword: String,
    onKeywordChange: (String) -> Unit,
    listFoods: List<Food>,
    detailNavigation: (Int) -> Unit,
) {
    Column {
        Spacer(modifier = Modifier.height(12.dp))
        SearchBar(keyword = keyword, onKeywordChange = onKeywordChange)
        LazyChipList(modifier = modifier)
        LazyFoodsList(
            foodsList = listFoods,
            modifier = modifier,
            detailNavigation = detailNavigation
        )
    }
}

