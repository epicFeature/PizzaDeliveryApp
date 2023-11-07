package com.example.fooddeliveryapp.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fooddeliveryapp.ui.main.tabmenu.ComboFragment
import com.example.fooddeliveryapp.ui.main.tabmenu.DessertFragment
import com.example.fooddeliveryapp.ui.main.tabmenu.DrinkFragment
import com.example.fooddeliveryapp.ui.main.tabmenu.PizzaFragment

class PagerAdapter(fragment: MainFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PizzaFragment()
            1 -> ComboFragment()
            2 -> DessertFragment()
            3 -> DrinkFragment()
            else ->
                PizzaFragment()
        }
    }
}