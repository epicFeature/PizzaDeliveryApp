package com.example.fooddeliveryapp.ui.main

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentMainBinding
import com.example.fooddeliveryapp.ui.foodview.FoodRecyclerViewAdapter
import com.example.fooddeliveryapp.ui.main.viewmodel.PizzaViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeTab()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeTab() {
        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Пицца"
                }

                1 -> {
                    tab.text = "Комбо"
                }

                2 -> {
                    tab.text = "Десерты"
                }

                else -> {
                    tab.text = "Напитки"
                }
            }
        }.attach()
    }
}