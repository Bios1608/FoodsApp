package com.example.foodslist.data.model

data class Food (
    val id: Int,
    val name: String,
    val shop: String,
    val location: String,
    val photoUrl:String,
    val description:String,
    var favorite:Boolean = false
)