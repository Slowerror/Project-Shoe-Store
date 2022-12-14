package com.bignerdranch.android.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String = "",
    var company: String = "",
    var size: String = "",
    var description: String = "",
    val images: List<String> = mutableListOf()
) : Parcelable


