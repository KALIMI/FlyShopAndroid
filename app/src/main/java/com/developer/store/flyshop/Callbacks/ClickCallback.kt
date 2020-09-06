package com.developer.store.flyshop.Callbacks

import com.developer.store.flyshop.models.ProductViewModel

interface ClickCallback {
    fun productClicked(product: ProductViewModel)
}