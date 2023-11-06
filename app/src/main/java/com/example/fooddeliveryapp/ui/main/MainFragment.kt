package com.example.fooddeliveryapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.databinding.FragmentMainBinding
import com.example.fooddeliveryapp.ui.foodview.FoodRecycleViewAdapter
import com.example.fooddeliveryapp.ui.main.viewmodel.PizzaViewModel

class MainFragment : Fragment() {
    lateinit var recyclerAdapter: FoodRecycleViewAdapter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        initRecyclerView()
        initViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerAdapter = FoodRecycleViewAdapter()
        binding.menuRecyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel() {
        val viewModel: PizzaViewModel = ViewModelProvider(this)[PizzaViewModel::class.java]
        viewModel.observer.observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerAdapter.setData(it)
            } else{
                Toast.makeText(this.requireContext(), "Ой, что-то пошло не так. Попробуйте позже.", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.makeApiCall()
    }

}