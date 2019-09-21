package com.mucahitkambur.kariyerchallenge.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mucahitkambur.kariyerchallenge.databinding.ItemOrderLayoutBinding
import com.mucahitkambur.kariyerchallenge.model.OrderResult

class OrderAdapter(private val orderList: List<OrderResult>)
    : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return OrderViewHolder(ItemOrderLayoutBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orderList[position])

        // Order Detail'in görünürlüğü için order'ın dinlenmesi
        holder.binding.linearOrder.setOnClickListener {view ->
            val productDetailVisibility = holder.binding.relativeDetail.isVisible
            holder.binding.relativeDetail.visibility = if (productDetailVisibility)
                View.GONE
            else
                View.VISIBLE
        }
    }

    override fun getItemCount(): Int = orderList.size

    class OrderViewHolder(val binding: ItemOrderLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: OrderResult){
            // OrderResult nesnesinin databinding ile xml'e verilmesi
            binding.order = order
            binding.executePendingBindings()
        }
    }

}