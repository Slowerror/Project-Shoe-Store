package com.bignerdranch.android.shoestore.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String = "",
    var company: String = "",
    var size: String = "",
    var description: String = "",
    val images: List<String> = mutableListOf()
) : Parcelable


