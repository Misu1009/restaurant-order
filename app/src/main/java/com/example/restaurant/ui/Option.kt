package com.example.restaurant.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurant.datasource.DataSource
import com.example.restaurant.model.Item

@Composable
fun OptionPart(
    selectedButton: Boolean,
    data: Item,
    onClickHandling: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected =  selectedButton,
            onClick =onClickHandling
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = data.name , fontSize = 30.sp)
            Text(
                text = data.description ,
                fontSize = 20.sp ,
                modifier = Modifier.padding(
                    top = 5.dp ,
                    bottom = 5.dp
                )
            )
            Text(text = "$"+data.price , fontSize = 15.sp)
            Divider(
                thickness = 1.dp ,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}
@Composable
@Preview(showBackground = true)
fun OptionPreview(){
    var selectedButton by remember{ mutableStateOf(false) }
    OptionPart(selectedButton = selectedButton, data = DataSource.entreeMenuItems[1]){
        selectedButton = !selectedButton
    }
}