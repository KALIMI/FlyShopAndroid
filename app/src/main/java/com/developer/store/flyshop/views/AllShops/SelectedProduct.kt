package com.developer.store.flyshop.views.AllShops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import com.developer.store.flyshop.R
import com.developer.store.flyshop.models.ProductViewModel

class SelectedProduct : Fragment() {

    lateinit var product: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        product = arguments?.getSerializable("product") as ProductViewModel

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selected_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val productName = view.findViewById<TextView>(R.id.productName)
        if ( product != null ) {
            productName.text = product.name
        }

    }

}