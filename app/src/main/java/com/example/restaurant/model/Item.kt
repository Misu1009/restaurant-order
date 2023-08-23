package com.example.restaurant.model

data class Item(
    val name: String,
    val description: String,
    val price: String,
    val selectedButton: Boolean = false
)