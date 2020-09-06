package com.developer.store.flyshop.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.developer.store.flyshop.services.SaleService

class SaleVMFactory( private val service: SaleService ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(SaleViewModel::class.java)) {
            return SaleViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}