package com.developer.store.flyshop.repositories

import com.developer.store.flyshop.models.ProductModel
import com.developer.store.flyshop.services.SaleService
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.rxjava3.core.Observable

class SaleRepository: SaleService {
    val db = FirebaseFirestore.getInstance()

    override fun fetchFirebaseData(): Observable<ProductModel> {
        return Observable.create {
            db.collection("AllShops").get().addOnCompleteListener { task ->
                if ( task.isSuccessful ) {
                    for ( document in task.result!! ) {
                        document.reference.collection("products").whereGreaterThan("sale", 0).get().addOnCompleteListener { saleTask ->
                            if (saleTask.isSuccessful && !saleTask.result?.isEmpty!!) {
                                for (saleProduct in saleTask.result!! ) {
                                    val cur = saleProduct.toObject(ProductModel::class.java)
                                        it.onNext(cur)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}