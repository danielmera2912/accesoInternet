package com.example.accesointernet.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.accesointernet.network.ColorApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response


    init {
        getColorRealEstateProperties()
    }


    private fun getColorRealEstateProperties() {
        ColorApi.RETROFIT_SERVICE.getProperties().enqueue( object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Fallo: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
    }


}