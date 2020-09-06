package com.developer.store.flyshop.repositories

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.developer.store.flyshop.models.ProductModel
import com.developer.store.flyshop.services.NewService
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.rxjava3.core.Observable
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

class NewRepository: NewService {
    private val db = FirebaseFirestore.getInstance()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun fetchFirebaseData(): Observable<ProductModel> {
        return Observable.create {
            db.collection("AllShops").get().addOnCompleteListener { task ->
                if ( task.isSuccessful ) {
                    for ( document in task.result!! ) {
                        document.reference.collection("products").get().addOnCompleteListener { saleTask ->
                            if (saleTask.isSuccessful && !saleTask.result?.isEmpty!!) {
                                for (saleProduct in saleTask.result!! ) {
                                    val cur = saleProduct.toObject(ProductModel::class.java)
                                    if ( cur.date?.let { it1 -> date(it1) } == true ) {
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

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    fun date(productDate: String): Boolean {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = sdf.format(Date())

        val today = LocalDate.parse(currentDate)
        val productEnterDate = LocalDate.parse(productDate)
        val period = Period.between( today, productEnterDate)

        return period.toTotalMonths() >= 0

    }
}