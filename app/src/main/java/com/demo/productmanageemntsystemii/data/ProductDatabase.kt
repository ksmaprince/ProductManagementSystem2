package com.demo.productmanageemntsystemii.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], exportSchema = false, version = 1)
abstract class ProductDatabase : RoomDatabase(){
    abstract fun getProductDao(): ProductDAO
}