package com.companyname.apple_market

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val icon: Int,
    val productName: String,
    val productExplanation: String,
    val name: String,
    val price: Int,
    val address: String,
    val like: Int,
    val chat: Int
):Parcelable