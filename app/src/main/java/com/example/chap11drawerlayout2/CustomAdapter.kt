package com.example.chap11drawerlayout2

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chap11drawerlayout2.databinding.ItemMainBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import java.text.DecimalFormat

class CustomAdapter(val datalist: MutableList<DataVO>):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val customViewHolder = CustomViewHolder(binding)

        customViewHolder.itemView.setOnClickListener {
            val position: Int = customViewHolder.bindingAdapterPosition
            val dataVO = datalist.get(position)
            Toast.makeText(
                parent.context,
                "은행: ${dataVO.bank} - 국적:${dataVO.nation}",
                Toast.LENGTH_SHORT
            ).show()
        }

        customViewHolder.itemView.setOnLongClickListener{
            val position: Int = customViewHolder.bindingAdapterPosition
            val dataVO = datalist.get(position)
            (parent.context as MainActivity).twoFragment.refreshRecyclerViewDrop(dataVO)
            true
        }
        return customViewHolder
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = (holder as CustomViewHolder).binding
        val dataVO = datalist.get(position)
        binding.ivBank.setImageResource(dataVO.picture)
        binding.tvName.text = dataVO.name
        binding.tvbank.text = dataVO.bank
        binding.tvMoney.text = dataVO.money
    }

    class CustomViewHolder(val binding: ItemMainBinding):RecyclerView.ViewHolder(binding.root)
}