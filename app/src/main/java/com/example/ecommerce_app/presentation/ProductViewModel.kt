package com.example.ecommerce_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce_app.data.ProductRepository
import com.example.ecommerce_app.data.Result
import com.example.ecommerce_app.data.model.Product
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ProductViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()
    private val __showErrorToastChannel = Channel<Boolean>()
    val showErrorChannel = __showErrorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            productRepository.getProductsList().collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        __showErrorToastChannel.send(true)
                    }

                    is Result.Success -> {
                        result.data?.let { products ->
                            _products.update { products }
                        }
                    }
                }
            }
        }
    }
}