package com.developer.store.flyshop.models

import com.google.gson.annotations.SerializedName

data class ProductModel (@SerializedName("ar") var ar: Boolean? = null,
                         @SerializedName("brand") var brand: String? = null,
                         @SerializedName("category") var category: String? = null,
                         @SerializedName("color") var color: String? = null,
                         @SerializedName("date") var date: String? = null,
                         @SerializedName("description") var description: String? = null,
                         @SerializedName("gender") var gender: String? = null,
                         @SerializedName("images") var images: List<String>? = null,
                         @SerializedName("productId") var productId: String? = null,
                         @SerializedName("productName") var productName: String? = null,
                         @SerializedName("productPrice") var productPrice: Int? = null,
                         @SerializedName("productSize") var productSize: List<String>? = null,
                         @SerializedName("sale") var sale: Int? = null,
                         @SerializedName("type") var type: String? = null
)