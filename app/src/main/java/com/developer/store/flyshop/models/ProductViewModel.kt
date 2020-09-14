package com.developer.store.flyshop.models

import java.io.Serializable

class ProductViewModel( val product: ProductModel) : Serializable{

    var ar: Boolean? = product.ar
    var brand: String? = product.brand
    var category: String? = product.category
    var color: String? = product.color
    var date: String? = product.date
    var description: String? = product.description
    var gender: String? = product.gender
    var images: List<String>? = product.images
    var id: String? = product.productId
    var name: String = product.productName.toString()
    var price: String = (product.productPrice?.minus((product.productPrice?.times(product.sale!!) ?: 100) / 100)).toString()
    var size: List<String>? = product.productSize
    var sale: Int? = product.sale
    var type: String? = product.type
}

