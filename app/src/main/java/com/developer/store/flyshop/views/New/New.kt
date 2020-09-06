package com.developer.store.flyshop.views.New

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.flyshop.Adapters.NewProductsAdapter
import com.developer.store.flyshop.Callbacks.ClickCallback
import com.developer.store.flyshop.R
import com.developer.store.flyshop.models.ProductModel
import com.developer.store.flyshop.models.ProductViewModel
import com.developer.store.flyshop.repositories.NewRepository
import com.developer.store.flyshop.viewmodels.NewVMFactory
import com.developer.store.flyshop.viewmodels.NewViewModel
import com.developer.store.flyshop.views.AllShops.SelectedProduct

class New : Fragment(), ClickCallback {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        val newProductsList = view.findViewById<RecyclerView>(R.id.newProductsList)
        val adapter = NewProductsAdapter(ArrayList(), this)

        newProductsList.layoutManager = layoutManager
        newProductsList.adapter = adapter



        val newRepo = NewRepository()
        val viewModel: NewViewModel by lazy {
            ViewModelProviders.of(this, NewVMFactory(newRepo)).get(NewViewModel::class.java)
        }


        viewModel.getNewProducts()
        viewModel.getNewProductsLiveData().observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

    }

    override fun productClicked(product: ProductViewModel) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, SelectedProduct())?.commit()
    }
}