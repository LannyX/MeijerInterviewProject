package com.lanny.meijerinterviewproject.model

import com.google.gson.annotations.SerializedName

data class MeijerCoupon ( @SerializedName("couponCount") val couponCount : String,
                        @SerializedName("availableCouponCount") val availableCouponCount : String,
                        @SerializedName("listOfCoupons") val listOfCoupons:List<ListOfCoupons> )