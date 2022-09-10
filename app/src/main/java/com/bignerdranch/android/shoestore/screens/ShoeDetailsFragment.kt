package com.bignerdranch.android.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.shoestore.R
import com.bignerdranch.android.shoestore.databinding.FragmentShoeDetailsBinding
import com.bignerdranch.android.shoestore.model.Shoe

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding

    private val viewModel: ShoeSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.shoeData = Shoe()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.saveButton.setOnClickListener {
            onSave()
        }
    }

    private fun onSave() {
        val bindingData = binding.shoeData
        val name = bindingData?.name.toString()
        val size = bindingData?.size.toString()
        val company = bindingData?.company.toString()
        val description = bindingData?.description.toString()

        if (name.isNotEmpty() || company.isNotEmpty() || size.isNotEmpty() || description.isNotEmpty()) {
            viewModel.addShoe(name, company, size, description)
            findNavController().popBackStack()
        } else {
            Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
        }

    }
}