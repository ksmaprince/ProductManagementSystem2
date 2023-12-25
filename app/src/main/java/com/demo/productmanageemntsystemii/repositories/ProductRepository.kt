package com.demo.productmanageemntsystemii.repositories

import androidx.lifecycle.LiveData
import com.demo.productmanageemntsystemii.data.Product
import com.demo.productmanageemntsystemii.data.ProductDAO
import javax.inject.Inject

class ProductRepository @Inject constructor(val productDAO: ProductDAO) {

    suspend fun saveProduct(product: Product) {
        productDAO.insertProduct(product = product)
    }

    suspend fun updateProduct(product: Product) {
        productDAO.updateProduct(product = product)
    }

    fun getAllProducts(): LiveData<List<Product>> {
        return productDAO.getAllProducts()
    }

    suspend fun deleteProduct(product: Product) {
        productDAO.deleteProduct(product = product)
    }
}