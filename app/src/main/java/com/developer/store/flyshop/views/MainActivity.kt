package com.developer.store.flyshop.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.developer.store.flyshop.R
import com.developer.store.flyshop.views.AllShops.AllShops
import com.developer.store.flyshop.views.Cart.Cart
import com.developer.store.flyshop.views.Home.Home
import com.developer.store.flyshop.views.New.New
import com.developer.store.flyshop.views.Sale.Sale
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = Navigation.findNavController(this, R.id.fragment)
        navBar.itemIconTintList = null

        NavigationUI.setupWithNavController(navBar, navController)

    }
}