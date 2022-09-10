package com.bignerdranch.android.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.shoestore.models.Shoe

class ShoeSharedViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private var shoeList = mutableListOf<Shoe>()

    init {
        _shoes.value = shoeList
    }

    fun addShoe(name: String, company: String, size: String, description: String) {
        val item = Shoe(name, company, size, description)
        shoeList.add(item)
    }
}