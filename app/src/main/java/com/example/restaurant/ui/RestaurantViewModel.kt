package com.example.restaurant.ui

import androidx.lifecycle.ViewModel
import com.example.restaurant.model.Item
import com.example.restaurant.model.RestaurantState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RestaurantState())
    val uiState: StateFlow<RestaurantState> = _uiState.asStateFlow()

    fun addEntreeList(data: MutableList<Item>){
        for(item in data){
            if(item.selectedButton == true){
                _uiState.value.entreeList.add(item)
            }
        }
    }
    fun removeEntreeList(){
        _uiState.value.entreeList.clear()
    }
    fun addSideDishList(data: MutableList<Item>){
        for(item in data){
            if(item.selectedButton == true){
                _uiState.value.sideDishList.add(item)
            }
        }
    }
    fun removeSideDishList(){
        _uiState.value.sideDishList.clear()
    }
    fun addAccompanimentList(data: MutableList<Item>){
        for(item in data){
            if(item.selectedButton == true){
                _uiState.value.accompanimentList.add(item)
            }
        }
    }
    fun removeAccompanimentList(){
        _uiState.value.accompanimentList.clear()
    }
    fun removeAllList(){
        removeEntreeList()
        removeSideDishList()
        removeAccompanimentList()
    }
}