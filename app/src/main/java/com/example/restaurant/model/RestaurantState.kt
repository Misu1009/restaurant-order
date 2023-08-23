package com.example.restaurant.model

data class RestaurantState(
    var entreeList: MutableList<Item> = mutableListOf(),
    var sideDishList: MutableList<Item> = mutableListOf(),
    var accompanimentList: MutableList<Item> = mutableListOf()
)
