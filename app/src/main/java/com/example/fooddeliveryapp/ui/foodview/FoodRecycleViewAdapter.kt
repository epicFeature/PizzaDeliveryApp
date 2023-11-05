package com.example.fooddeliveryapp.ui.foodview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.api.common.model.Food
import com.example.fooddeliveryapp.databinding.FoodRecyclerViewBinding

class FoodRecycleViewAdapter(
) : RecyclerView.Adapter<FoodRecycleViewAdapter.FoodViewHolder>() {

    private var data: List<Food> = emptyList()
        set(newValue) {
            field = newValue
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

    override fun getItemCount(): Int = data.count()

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int
    ) {
        val food = data[position]
        val context = holder.itemView.context

        with(holder.binding) {
            foodName.text = food.name
            foodDescription.text = food.name
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