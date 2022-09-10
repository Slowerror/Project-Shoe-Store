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
import com.bignerdranch.android.shoestore.models.Shoe
import com.bignerdranch.android.shoestore.viewModels.ShoeSharedViewModel

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

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoesListFragment)
        }

        binding.buttonSave.setOnClickListener {
            onSave()
        }
    }

    private fun onSave() {
        val newShoe = binding.shoeData
        val name = newShoe?.name.toString()
        val size = newShoe?.size.toString()
        val company = newShoe?.company.toString()
        val description = newShoe?.description.toString()

        if (name.isEmpty() || company.isEmpty() || size.isEmpty() || description.isEmpty()) {
            Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addShoe(name, company, size, description)
            findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoesListFragment)

        }

    }
}