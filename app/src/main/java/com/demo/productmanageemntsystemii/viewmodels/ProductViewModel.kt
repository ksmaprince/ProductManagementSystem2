package com.demo.productmanageemntsystemii.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.productmanageemntsystemii.data.Product
import com.demo.productmanageemntsystemii.repositories.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {

    val products = repository.getAllProducts()

    fun saveProduct(product: Product) {
        viewModelScope.launch {
            repository.saveProduct(product = product)
        }
    }

    fun updateProduct(product: Product){
        viewModelScope.launch {
            repository.updateProduct(product = product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            repository.deleteProduct(product = product)
        }
    }

    //To hold product data
    val _product = mutableStateOf<Product?>(null)
    val product: State<Product?>
        get() = _product

    fun setProduct(product: Product){
        _product.value = product
    }
}