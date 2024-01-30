package com.example.ecommerce_app.data

import com.example.ecommerce_app.data.model.Product
import kotlinx.coroutines.flow.Flow


interface ProductRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}