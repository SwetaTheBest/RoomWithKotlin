package com.swetajain.roomwithkotlin.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.roomwithkotlin.R
import com.swetajain.roomwithkotlin.adapters.ContactsAdapter
import com.swetajain.roomwithkotlin.database.contacts.ContactsViewModel
import com.swetajain.roomwithkotlin.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var mViewModel: ContactsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        Log.d("TAG", "Fragment: onCreateView")
        return binding.root
    }

    override fun onAttach(context: Context) {
        Log.d("TAG", "Fragment: onAttach context")

        super.onAttach(context)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.d("TAG", "Fragment: onAttach activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "Fragment: onViewCreated")
        mViewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)
        val adapter = ContactsAdapter()
        recyclerView = binding.mainRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mViewModel.readAllData.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })
        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_secondaryFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "Fragment:  onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Fragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Fragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "Fragment: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "Fragment: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TAG", "Fragment: onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "Fragment: onDestroyView")

        _binding = null
    }
}