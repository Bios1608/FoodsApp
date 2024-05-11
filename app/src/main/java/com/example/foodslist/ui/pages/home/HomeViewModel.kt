package com.example.foodslist.ui.pages.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodslist.data.model.Food
import com.example.foodslist.data.repository.FoodRepository
import com.example.foodslist.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
) : ViewModel() {
    private val _foodList: MutableStateFlow<State<List<Food>>> = MutableStateFlow(State.Loading)
    val foodList: StateFlow<State<List<Food>>> get() = _foodList.asStateFlow()

    private val _searchKeyword = mutableStateOf("")
    val searchKeyword: androidx.compose.runtime.State<String> get() = _searchKeyword

    fun search(keyword: String) = viewModelScope.launch {
        _searchKeyword.value = keyword
        foodRepository.searchFoodData(_searchKeyword.value).catch {
            _foodList.value = State.Error(it.message.toString())
        }.collect { listFood ->
            _foodList.value = State.Success(listFood)
        }
    }
}