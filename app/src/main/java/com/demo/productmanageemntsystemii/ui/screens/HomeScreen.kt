package com.demo.productmanageemntsystemii.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.productmanageemntsystemii.data.Product
import com.demo.productmanageemntsystemii.ui.theme.ProductManageemntSystemIITheme
import com.demo.productmanageemntsystemii.viewmodels.ProductViewModel

@Composable
fun HomeScreen(
    viewmodel: ProductViewModel,
    navController: NavController
) {
    var products by remember {
        mutableStateOf(listOf<Product>())
    }
    viewmodel.products.observeForever {
        products = it
    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(products) {
                ProductItem(
                    product = it,
                    onClickItem = {
                        viewmodel.setProduct(it)
                        navController.navigate("edit")
                    }, onClose = {
                        viewmodel.deleteProduct(it)
                    })
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate("add")
            },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add New")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(product: Product, onClickItem: () -> Unit, onClose: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = CardDefaults.outlinedShape,
        onClick = onClickItem
    ) {
        Row(
            Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                Text(text = product.title)
                Text(text = product.origin)
                Text(text = product.price)
            }
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Remove")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductManageemntSystemIITheme {
        // ProductItem(Product(0, "Book1", "US", "$.200"))
    }
}