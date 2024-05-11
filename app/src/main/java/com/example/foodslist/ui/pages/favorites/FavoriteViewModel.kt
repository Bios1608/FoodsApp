package com.example.foodslist.ui.pages.favorites

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
class FavoriteViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {
    private val _foodList: MutableStateFlow<State<List<Food>>> = MutableStateFlow(State.Loading)
    val foodList: StateFlow<State<List<Food>>> get() = _foodList.asStateFlow()

    fun getFavoriteFoods()=viewModelScope.launch {
            repository.getFavoriteFoodsData().catch {
                _foodList.value = State.Error(message = it.message.toString())
            }.collect{foodList->
                _foodList.value = State.Success(foodList)
            }
    }
}