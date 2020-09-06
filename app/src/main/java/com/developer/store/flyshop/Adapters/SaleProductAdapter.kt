package com.developer.store.flyshop.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.flyshop.Callbacks.ClickCallback
import com.developer.store.flyshop.R
import com.developer.store.flyshop.Utils.GlideApp
import com.developer.store.flyshop.models.ProductViewModel
import kotlinx.android.synthetic.main.single_new_product.view.*

class SaleProductAdapter( private var list: ArrayList<ProductViewModel>, private val clickCallback: ClickCallback): RecyclerView.Adapter<SaleProductAdapter.SaleProductViewHolder>() {

    class SaleProductViewHolder( card: View): RecyclerView.ViewHolder( card )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_sale_product, parent, false )
        return SaleProductAdapter.SaleProductViewHolder( view )
    }

    override fun onBindViewHolder(holder: SaleProductViewHolder, i: Int) {
        with( holder ) {
            with( itemView ) {
                productName.text = list[i].name

                productPrice.setTextColor(Color.RED)
                productPrice.text = list[i].price

                GlideApp.with(productImage.context).load(list[i].images?.get(0)).into(productImage)
            }
        }

        holder.itemView.setOnClickListener {
            clickCallback.productClicked(list[i])
        }

    }

    fun setData( products: ArrayList<ProductViewModel>) {
        list = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

}