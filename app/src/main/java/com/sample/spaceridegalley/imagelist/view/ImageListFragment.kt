package com.sample.spaceridegalley.imagelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.imagefeaturelibrary.common.util.Constants.ColumnCount
import com.sample.imagefeaturelibrary.imagelist.view.ImageListViewModel
import com.sample.imagefeaturelibrary.imagelist.view.ListImageUiState
import com.sample.spaceridegalley.databinding.FragmentImageListListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * This is the fragment which shows list of media tiles in grid fashion list. Click on any tiles will take you to ImageDetailFragment
 * */
@AndroidEntryPoint
class ImageListFragment : Fragment() {

    private var _binding: FragmentImageListListBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ImageListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageListListBinding.inflate(inflater, container, false)
        binding.gridList.apply {
            layoutManager = when {
                ColumnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, ColumnCount)
            }
            adapter = ImageListRecyclerViewAdapter(mutableListOf())
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is ListImageUiState.LOADED -> {
                            // when data is available show the RCV and hide the loading message
                            binding.waitMsgView.visibility = View.GONE
                            binding.gridList.visibility = View.VISIBLE
                            (binding.gridList.adapter as ImageListRecyclerViewAdapter).submitItems(uiState.imageList)
                        }
                        ListImageUiState.UNINITIALIZED -> {
                            // when data is still being loaded hide the RCV and show the loading message
                            binding.gridList.visibility = View.INVISIBLE
                            binding.waitMsgView.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
