package com.companyname.apple_market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.companyname.apple_market.databinding.ItemBinding
import java.text.DecimalFormat

class MyAdapter(val mItems: MutableList<Item>) : RecyclerView.Adapter<MyAdapter.Holder>() {
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        holder.iconImageView.setImageResource(mItems[position].icon)

        holder.productName.text=mItems[position].productName
        holder.address.text = mItems[position].address

        val price = mItems[position].price
        holder.price.text = DecimalFormat("#,###").format(price)+"원"

        holder.chatCount.text = mItems[position].chat.toString()
        holder.heartCount.text = mItems[position].like.toString()
    }

    inner class Holder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.icon
        val productName = binding.produtName
        val address = binding.address
        val price = binding.price
        val chatCount = binding.chatcount
        val heartCount = binding.heartcount
    }

}