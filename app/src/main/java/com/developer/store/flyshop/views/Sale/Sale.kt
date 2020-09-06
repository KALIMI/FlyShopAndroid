package com.developer.store.flyshop.views.Sale

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.flyshop.Adapters.NewProductsAdapter
import com.developer.store.flyshop.Adapters.SaleProductAdapter
import com.developer.store.flyshop.Callbacks.ClickCallback
import com.developer.store.flyshop.R
import com.developer.store.flyshop.models.ProductViewModel
import com.developer.store.flyshop.repositories.SaleRepository
import com.developer.store.flyshop.viewmodels.NewVMFactory
import com.developer.store.flyshop.viewmodels.NewViewModel
import com.developer.store.flyshop.viewmodels.SaleVMFactory
import com.developer.store.flyshop.viewmodels.SaleViewModel
import com.developer.store.flyshop.views.AllShops.SelectedProduct
import kotlinx.android.synthetic.main.fragment_sale.*

class Sale : Fragment(), ClickCallback {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sale, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        val saleProductList = view.findViewById<RecyclerView>(R.id.saleProductList)
        val adapter = SaleProductAdapter(ArrayList(), this)

        saleProductList.layoutManager = layoutManager
        saleProductList.adapter = adapter

        val repo = SaleRepository()
        val viewModel: SaleViewModel by lazy {
            ViewModelProviders.of(this, SaleVMFactory(repo)).get(SaleViewModel::class.java)
        }

        viewModel.getSaleProducts()
        viewModel.getSaleProductsLiveData().observe(this, Observer {
            adapter.setData(it)
        })
    }

    override fun productClicked(product: ProductViewModel) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, SelectedProduct())?.commit()
    }

}