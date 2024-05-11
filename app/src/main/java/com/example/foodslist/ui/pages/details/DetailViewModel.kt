package com.example.foodslist.ui.pages.details

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
class DetailViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {
    private val _food: MutableStateFlow<State<Food>> = MutableStateFlow(State.Loading)
    val food: StateFlow<State<Food>> get() = _food.asStateFlow()

    fun getFoodDetails(foodsId:Int)=viewModelScope.launch {
        repository.getDetailsFromFood(foodsId).catch {
            _food.value = State.Error(it.message.toString())
        }.collect{food->
            _food.value = State.Success(food)
        }
    }
}