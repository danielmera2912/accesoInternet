package com.example.accesointernet.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://github.com/danielmera2912/BaseDeDatosAndroid/blob/master/colores.json"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ColorApiService {

    @GET("realestate")
    fun getProperties(): Call<String>


}

object ColorApi {
    val RETROFIT_SERVICE : ColorApiService by lazy { retrofit.create(ColorApiService::class.java) }
}
