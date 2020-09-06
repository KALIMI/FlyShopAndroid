package com.developer.store.flyshop.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developer.store.flyshop.Callbacks.ClickCallback
import com.developer.store.flyshop.R
import com.developer.store.flyshop.Utils.GlideApp
import com.developer.store.flyshop.models.ProductModel
import com.developer.store.flyshop.models.ProductViewModel
import kotlinx.android.synthetic.main.single_new_product.view.*

class NewProductsAdapter( private var list: ArrayList<ProductViewModel>, private val clickProduct: ClickCallback): RecyclerView.Adapter<NewProductsAdapter.NewProductsViewHolder>() {

    class NewProductsViewHolder( card: View): RecyclerView.ViewHolder( card )

    override fun onCreateViewHolder( parent: ViewGroup, i: Int): NewProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_new_product, parent, false )
        return NewProductsViewHolder( view )
    }

    override fun onBindViewHolder(holder: NewProductsViewHolder, i: Int) {

        with( holder ) {
            with( itemView ) {
                productPrice.setTextColor(Color.BLACK)

                productName.text = list[i].name
                if ( list[i].sale != 0 ) {
                    productPrice.setTextColor(Color.RED)
                }
                productPrice.text = list[i].price
                GlideApp.with(productImage.context).load(list[i].images?.get(0)).into(productImage)
            }
        }

        holder.itemView.setOnClickListener {
            clickProduct.productClicked(list[i])
        }
    }

    fun setData(products: ArrayList<ProductViewModel>) {
        list = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}