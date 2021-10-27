package com.swetajain.roomwithkotlin.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.swetajain.roomwithkotlin.R
import com.swetajain.roomwithkotlin.database.contacts.Contact
import com.swetajain.roomwithkotlin.database.contacts.ContactsViewModel
import com.swetajain.roomwithkotlin.databinding.FragmentSecondaryBinding

class SecondaryFragment : Fragment() {
    private var _binding: FragmentSecondaryBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: ContactsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondaryBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)
        binding.btnAdd.setOnClickListener {
            addContact()
        }
        return binding.root
    }

    private fun addContact() {
        var name = binding.tietName.text.toString()
        var phone = binding.tietNum.text.toString()
        var email = binding.tietEmail.text.toString()
        if (inputCheck(name, phone, email)) {
            var contact = Contact(0, name, phone, null, email)
            mViewModel.addContact(contact)
            Toast.makeText(requireContext(), "Contact added successfully!", Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_secondaryFragment_to_mainFragment)
        } else {
            Toast.makeText(requireContext(), "Please add the fields correctly!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(name: String, phone: String, email: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> false
            TextUtils.isEmpty(phone) -> false
            TextUtils.isEmpty(email) -> false
            !TextUtils.isDigitsOnly(phone) -> false
            else -> true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}