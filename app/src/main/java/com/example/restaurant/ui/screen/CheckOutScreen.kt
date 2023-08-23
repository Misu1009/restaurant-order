package com.example.restaurant.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restaurant.R
import com.example.restaurant.datasource.DataSource
import com.example.restaurant.model.Item
import com.example.restaurant.ui.RestaurantViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen(
    onCancelButton: ()->Unit,
    onSUbmitButton: ()->Unit,
    viewModel: RestaurantViewModel
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Order Checkout") } ,
                navigationIcon = {
                    IconButton(onClick = onCancelButton) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ){
        Column(modifier=Modifier
            .padding(it)
            .fillMaxSize()) {
            Text(text="Order Summary", fontWeight = FontWeight.Bold, fontSize = 20.sp)

            menu(data=viewModel.uiState.value.entreeList)
            menu(data=viewModel.uiState.value.sideDishList)
            menu(data=viewModel.uiState.value.accompanimentList)

            Divider(
                thickness = 1.dp ,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            val subtotal = calculateTotal(viewModel = viewModel)
            val tax = subtotal/10
            val total = subtotal+tax

            Text(text="Subtotal: $" + subtotal, Modifier.align(Alignment.End))
            Text(text="Tax: $" + tax, Modifier.align(Alignment.End))
            Text(text="Total: $" + total, Modifier.align(Alignment.End))

            Row{
                Button(
                    onClick = onSUbmitButton,
                    border = BorderStroke(1.dp , Color.Green) ,
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green),
                    modifier = Modifier.weight(1f)
                    ) {
                         Text(text = "Submit" , color = Color.Black)
                    }
            }

        }
    }
}
@Composable
fun menu(data: MutableList<Item>){
    LazyColumn(){
        items(data){ item->
            Row(
                modifier =Modifier
                    .fillMaxWidth()
                    .padding(bottom=10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(text = item.name, fontSize = 15.sp)
                Text(text="$" + item.price, fontSize = 15.sp)
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun preview7(){
//    val viewModel : RestaurantViewModel = viewModel()
//    viewModel.addEntreeList(mutableListOf(
//        Item("awawawawawaw", "enak", "9", true),
//        Item("awawawawawaw", "enak", "9", true),
//        Item("awawawawawaw", "enak", "9", true),
//    ))
//    viewModel.addSideDishList(mutableListOf(
//        Item("bkawawawawawaw", "enak", "9", true),
//        Item("bkawawawawawaw", "enak", "9", true),
//        Item("bawawawawawawk", "enak", "9", true),
//    ))
//    viewModel.addAccompanimentList(mutableListOf(
//        Item("kfawawawawawawc", "enak", "9", true),
//        Item("kfawawawawawawc", "enak", "9", true),
//        Item("kawawawawawawfc", "enak", "9", true),
//    ))
//}
private fun calculateTotal(viewModel: RestaurantViewModel): Double{
    var total = 0.0;
    var price = 0.0;

    for(item in viewModel.uiState.value.entreeList){
        price += item.price.toDouble()
    }
    for(item in viewModel.uiState.value.sideDishList){
        price += item.price.toDouble()
    }
    for(item in viewModel.uiState.value.accompanimentList){
        price += item.price.toDouble()
    }
    return price
}