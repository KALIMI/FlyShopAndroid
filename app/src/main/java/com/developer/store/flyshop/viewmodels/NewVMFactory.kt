package com.developer.store.flyshop.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.developer.store.flyshop.services.NewService

class NewVMFactory( private val service: NewService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(NewViewModel::class.java)) {
            return NewViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}