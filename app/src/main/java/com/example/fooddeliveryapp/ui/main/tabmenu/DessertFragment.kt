package com.example.fooddeliveryapp.ui.main.tabmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.databinding.FragmentDessertBinding
import com.example.fooddeliveryapp.ui.foodview.FoodRecyclerViewAdapter
import com.example.fooddeliveryapp.ui.main.viewmodel.DessertViewModel


class DessertFragment : Fragment() {
    private lateinit var recyclerAdapter: FoodRecyclerViewAdapter

    private var _binding: FragmentDessertBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDessertBinding.inflate(inflater, container, false)
        initRecyclerView()
        initViewModel()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.dessertFragmentRecyclerView.layoutManager =
            LinearLayoutManager(this.requireContext())
        recyclerAdapter = FoodRecyclerViewAdapter()
        binding.dessertFragmentRecyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        val viewModel: DessertViewModel = ViewModelProvider(this)[DessertViewModel::class.java]
        viewModel.observer.observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerAdapter.setData(it)
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "Ой, что-то пошло не так. Попробуйте позже.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        viewModel.makeApiCall()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}