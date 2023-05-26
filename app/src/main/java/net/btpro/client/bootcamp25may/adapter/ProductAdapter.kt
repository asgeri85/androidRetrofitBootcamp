package net.btpro.client.bootcamp25may.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.btpro.client.bootcamp25may.databinding.ItemProductBinding
import net.btpro.client.bootcamp25may.model.ProductsReponseItem

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val productList = arrayListOf<ProductsReponseItem>()

    inner class ProductViewHolder(val itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val itemProduct = productList[position]

        holder.itemProductBinding.product = itemProduct

        Picasso.get().load(itemProduct.image).into(holder.itemProductBinding.imageView);
    }

    fun updateList(newList: List<ProductsReponseItem>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}