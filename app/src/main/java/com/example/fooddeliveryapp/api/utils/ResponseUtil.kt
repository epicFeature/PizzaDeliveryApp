package com.example.fooddeliveryapp.api.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.fooddeliveryapp.api.common.model.Food
import com.example.fooddeliveryapp.api.common.model.FoodData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseUtil {

    companion object {
        fun emerge(dataList: MutableLiveData<List<Food>?>, response: Call<FoodData>) {
            response.enqueue(object : Callback<FoodData> {
                override fun onFailure(
                    call: Call<FoodData>,
                    t: Throwable
                ) {
                    Log.e("httpCall", t.message ?:"Unknown Error")
                    dataList.postValue(null)
                }

                override fun onResponse(
                    call: Call<FoodData>,
                    response: Response<FoodData>
                ) {
                    Log.d("httpCall", response.body().toString())
                    dataList.postValue(response.body()?.data)
                }
            })
        }
    }
}