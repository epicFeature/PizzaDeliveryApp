package com.example.fooddeliveryapp.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.api.common.FoodRepository
import com.example.fooddeliveryapp.api.common.FoodType
import com.example.fooddeliveryapp.api.common.model.Food
import com.example.fooddeliveryapp.api.utils.ResponseUtil

class ComboViewModel : ViewModel() {
    var observer: MutableLiveData<List<Food>?> = MutableLiveData()

    fun makeApiCall() {
        ResponseUtil.emerge(observer, FoodRepository.getAll(FoodType.COMBO))
    }
}