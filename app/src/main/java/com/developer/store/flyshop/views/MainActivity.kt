package com.developer.store.flyshop.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
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
        navBar.selectedItemId = R.id.homeTab
        navBar.itemIconTintList = null

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, Home())
        fragmentTransaction.commit()

        navBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.shopsTab -> {
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment, AllShops())
                    fragmentTransaction.commit()
                    true
                }

                R.id.newTab -> {
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment, New())
                    fragmentTransaction.commit()
                    true
                }

                R.id.homeTab -> {

                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment, Home())
                    fragmentTransaction.commit()
                    true
                }

                R.id.salesTab -> {

                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment, Sale())
                    fragmentTransaction.commit()
                    true
                }

                R.id.cartTab -> {
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment, Cart())
                    fragmentTransaction.commit()
                    true
                }
                else -> { false}
            }
        }


    }
}