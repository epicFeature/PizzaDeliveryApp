package com.example.fooddeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddeliveryapp.databinding.ActivityMainBinding
import com.example.fooddeliveryapp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}