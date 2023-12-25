package com.demo.productmanageemntsystemii.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.productmanageemntsystemii.data.Product
import com.demo.productmanageemntsystemii.viewmodels.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    viewModel: ProductViewModel,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(10.dp)) {
        var title by rememberSaveable {
            mutableStateOf("")
        }
        var origin by rememberSaveable {
            mutableStateOf("")
        }
        var price by rememberSaveable {
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            label = {
                Text(text = "Product Title")
            },
            placeholder = {
                Text(text = "Enter Product Title")
            })
        OutlinedTextField(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            value = origin,
            onValueChange = { origin = it },
            label = {
                Text(text = "Product Origin")
            },
            placeholder = {
                Text(text = "Enter Product Origin")
            })
        OutlinedTextField(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            value = price,
            onValueChange = { price = it },
            label = {
                Text(text = "Product Price")
            },
            placeholder = {
                Text(text = "Enter Product Price")
            })

        Button(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            onClick = {
                viewModel.saveProduct(Product(0, title, origin, price))
                navController.popBackStack()
            }
        ) {
            Text(text = "Save Product")
        }
    }
}


