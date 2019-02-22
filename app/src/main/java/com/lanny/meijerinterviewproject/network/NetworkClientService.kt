package com.lanny.meijerinterviewproject.network

import com.lanny.meijerinterviewproject.model.ListOfCoupons
import com.lanny.meijerinterviewproject.model.MeijerCoupon
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface NetworkClientService {

    //https://meijerkraig.azurewebsites.net/api/Products?code=34lgBae%2FxIEnqksQpkn3w9F0JTKCafuiCr0ejLNLvBzlOlOZBa1CMA%3D%3D

    companion object Creator {
        fun create(): NetworkClientService{
            val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("https://meijerkraig.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(NetworkClientService::class.java)
        }
    }

    //?code=34lgBae%2FxIEnqksQpkn3w9F0JTKCafuiCr0ejLNLvBzlOlOZBa1CMA%3D%3D
    @GET("api/Products")
    fun getCoupon(@Query("code", encoded = true) code : String) : Observable<MeijerCoupon>


}