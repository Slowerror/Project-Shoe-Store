package com.bignerdranch.android.shoestore.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.shoestore.R
import com.bignerdranch.android.shoestore.databinding.FragmentShoesListBinding
import com.bignerdranch.android.shoestore.databinding.ItemShoeBinding
import com.bignerdranch.android.shoestore.model.Shoe

class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private val viewModel: ShoeSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)

        viewModel.shoes.observe(viewLifecycleOwner) { item ->
            createItemList(item)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabBtn.setOnClickListener {
            findNavController().navigate(R.id.action_shoesListFragment_to_shoeDetailsFragment)
        }

        setupMenu()
    }

    private fun createItemList(item: List<Shoe>) {
        item.forEach {
            val bindingView =
                ItemShoeBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.containerShoeList,
                    false)

            bindingView.shoeData = it

            binding.containerShoeList.addView(bindingView.root)
        }
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout_item -> {
                        findNavController().popBackStack(R.id.loginFragment, inclusive = false)
                        true
                    }
                    else -> false
                }

            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}