package com.demo.productmanageemntsystemii.di

import android.content.Context
import androidx.room.Room
import com.demo.productmanageemntsystemii.data.ProductDAO
import com.demo.productmanageemntsystemii.data.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideProductDao(productDatabase: ProductDatabase): ProductDAO =
        productDatabase.getProductDao()

    @Provides
    @Singleton
    fun provideProductDatabase(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "product_db"
        ).build()
    }
}