package com.developer.store.flyshop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.store.flyshop.models.ProductViewModel
import com.developer.store.flyshop.services.SaleService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class SaleViewModel( private val service: SaleService ) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val saleLiveData = MutableLiveData<ArrayList<ProductViewModel>>()

    init {
        this.saleLiveData.value = ArrayList()
    }

    fun getSaleProducts() {
        val disposable = service
            .fetchFirebaseData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val model = ProductViewModel(it)
                saleLiveData.value?.add(model)
                saleLiveData.value = saleLiveData.value
            },{
                println(it.localizedMessage)
            })

        compositeDisposable.add( disposable)
    }

    fun getSaleProductsLiveData(): LiveData<ArrayList<ProductViewModel>> = saleLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


}