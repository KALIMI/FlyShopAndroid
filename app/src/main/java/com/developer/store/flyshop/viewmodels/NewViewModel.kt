package com.developer.store.flyshop.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.store.flyshop.models.ProductModel
import com.developer.store.flyshop.models.ProductViewModel
import com.developer.store.flyshop.services.NewService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NewViewModel(private val service: NewService): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val newProductsLiveData = MutableLiveData<ArrayList<ProductViewModel>>()

    init {
        newProductsLiveData.value = ArrayList<ProductViewModel>()
    }


    fun getNewProducts() {
        val disposable = service
            .fetchFirebaseData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val model = ProductViewModel(it)
                newProductsLiveData.value?.add(model)
                newProductsLiveData.value = newProductsLiveData.value
            },{
                println(it.localizedMessage)
            })

        compositeDisposable.add(disposable)
    }

    fun getNewProductsLiveData(): LiveData<ArrayList<ProductViewModel>> {
        return newProductsLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}