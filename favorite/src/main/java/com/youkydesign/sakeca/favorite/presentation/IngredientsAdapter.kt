package com.youkydesign.sakeca.favorite.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.youkydesign.sakeca.favorite.databinding.ItemRowIngredientsBinding

class IngredientsAdapter(val recipeList: List<String>) :
    RecyclerView.Adapter<IngredientsAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder {
        val binding =
            ItemRowIngredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecipeViewHolder,
        position: Int
    ) {
        val ingredients = recipeList[position]
        holder.bind(ingredients)
    }

    override fun getItemCount(): Int = recipeList.size

    class RecipeViewHolder(val binding: ItemRowIngredientsBinding) : ViewHolder(binding.root) {
        fun bind(ingredient: String) {
            with(itemView) {
                binding.tvIngredientItem.text = ingredient
            }
        }
    }
}