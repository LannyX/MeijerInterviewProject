package com.lanny.meijerinterviewproject.model

import com.google.gson.annotations.SerializedName

data class ListOfCoupons (@SerializedName("title") val title: String,
                          @SerializedName("description") val description: String,
                          @SerializedName("imageURL") val imageUrl: String?,
                          @SerializedName("redemptionEndDate") val date:String

)