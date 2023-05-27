package com.sample.spaceridegalley.imagedetails.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.spaceridegalley.common.data.StaticDataSource
import com.sample.spaceridegalley.databinding.FragmentImageDetailBinding
import javax.sql.DataSource

class ImageDetailFragment : Fragment() {

    private lateinit var viewModel: ImageDetailViewModel
    private var selectedPosition = 0
    private var _binding: FragmentImageDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           selectedPosition = it.getInt("selectedPosition")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        binding.asdasd.text = arguments?.getString("selectedPosition") ?: "sdfsdf"
        binding.asdasd2.text = "sdfsdfsdfsfdsdfsdfsdfsdfsdf"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}