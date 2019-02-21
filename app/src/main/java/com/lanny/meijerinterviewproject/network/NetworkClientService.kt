package com.lanny.meijerinterviewproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetworkClientService {

    //https://meijerkraig.azurewebsites.net/api/Products?code=34lgBae%2FxIEnqksQpkn3w9F0JTKCafuiCr0ejLNLvBzlOlOZBa1CMA%3D%3D

    companion object Creator {
        fun create(): NetworkClientService{
            val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("https://meijerkraig.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NetworkClientService::class.java)
        }
    }

    @GET("api/Products?code=34lgBae%2FxIEnqksQpkn3w9F0JTKCafuiCr0ejLNLvBzlOlOZBa1CMA%3D%3D")
    fun getCoupon()


}