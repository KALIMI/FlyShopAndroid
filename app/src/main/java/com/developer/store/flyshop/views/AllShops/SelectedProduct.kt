package com.developer.store.flyshop.views.AllShops

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import com.developer.store.flyshop.R

class SelectedProduct : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_selected_product, container, false)
    }

}