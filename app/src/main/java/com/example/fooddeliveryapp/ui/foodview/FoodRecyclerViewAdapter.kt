package com.example.fooddeliveryapp.ui.foodview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.api.common.model.Food
import com.example.fooddeliveryapp.databinding.FoodRecyclerViewBinding

class FoodRecyclerViewAdapter(
) : RecyclerView.Adapter<FoodRecyclerViewAdapter.FoodViewHolder>() {

    private var _data: List<Food> = emptyList()
    fun setData(data: List<Food>) {
        _data = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodRecyclerViewBinding.inflate(inflater, parent, false)
        return FoodViewHolder(binding)
    }

    override fun getItemCount(): Int = _data.count()

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int
    ) {
        val food = _data[position]
        val context = holder.itemView.context

        with(holder.binding) {
            foodName.text = food.name
            foodDescription.text = food.description
            price.text = "от ${food.price}р."
            Glide.with(context)
                .load(food.photoUrl)
                .centerCrop()
                .placeholder(R.drawable.square_placeholder)
                .into(photoFoodPlaceholder)
        }
    }

    class FoodViewHolder(
        val binding: FoodRecyclerViewBinding
    ) : RecyclerView.ViewHolder(binding.root)

}