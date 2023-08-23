package com.example.restaurant.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.restaurant.R
import com.example.restaurant.datasource.DataSource
import com.example.restaurant.ui.OptionPart
import com.example.restaurant.ui.RestaurantViewModel

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideDishScreen(
    viewModel: RestaurantViewModel,
    navController: NavHostController,
    onCancelButton: ()->Unit
){
    var data by remember {
        mutableStateOf(DataSource.sideDishMenuItems)
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Choose Side Dish") } ,
                navigationIcon = {
                    IconButton(onClick = onCancelButton) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24) ,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ){
        Column (modifier = Modifier.padding(it)){
            LazyColumn {
                items(data) { item ->
                    OptionPart(selectedButton = item.selectedButton , data = item) {
                        val index = data.indexOf(item)
                        val temp = data.toMutableList()
                        temp[index] = data[index].copy(selectedButton = !data[index].selectedButton)
                        data = temp
                    }
                }
            }

            Row {
                Button(
                    onClick = onCancelButton,
                    border = BorderStroke(1.dp , Color.Red) ,
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Cancel" , color = Color.Black)
                }
                Button(
                    onClick = {
                        viewModel.addSideDishList(data)
                        navController.navigate("AccompanimentScreen")
                    },
                    border = BorderStroke(1.dp , Color.Green) ,
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Next" , color = Color.Black)
                }
            }
        }
    }
}