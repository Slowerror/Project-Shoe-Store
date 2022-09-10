package com.bignerdranch.android.shoestore.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.shoestore.model.Shoe

class ShoeSharedViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private var shoeList = mutableListOf<Shoe>()
//    private var shoeItem = Shoe("Jordan", "Nike", "43.0", "very good shoes")


    init {
//        Log.i("ViewModel", "viewModel is called")
//        shoeList.add(shoeItem)
        _shoes.value = shoeList
    }

    fun addShoe(name: String, company: String, size: String, description: String) {
        val item = Shoe(name, company, size, description)
        shoeList.add(item)
    }
}