package com.swetajain.roomwithkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.roomwithkotlin.databinding.FragmentSecondaryBinding

class SecondaryFragment : Fragment() {
    private var _binding: FragmentSecondaryBinding? = null
    private var binding = _binding!!
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.secondRecycler
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}