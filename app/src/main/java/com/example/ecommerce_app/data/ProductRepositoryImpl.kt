package com.example.ecommerce_app.data

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.ecommerce_app.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class ProductRepositoryImpl(private val api: Api) : ProductRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            val productsFromApi = try {
                api.getProductsList()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error Loading products"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error Loading products"))
                return@flow
            }
            emit(Result.Success(data = productsFromApi.products))

        }
    }
}