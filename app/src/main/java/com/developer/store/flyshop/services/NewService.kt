package com.developer.store.flyshop.services

import com.developer.store.flyshop.models.ProductModel
import io.reactivex.rxjava3.core.Observable

interface NewService {
    fun fetchFirebaseData() : Observable<ProductModel>
}