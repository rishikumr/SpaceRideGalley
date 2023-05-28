package com.sample.spaceridegalley.imagedetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.sample.spaceridegalley.databinding.FragmentImageDetailBinding
import com.sample.spaceridegalley.imagelist.ImageListRecyclerViewAdapter
import com.sample.spaceridegalley.util.Constants.SelectedPositionKey
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A fragment representing a detail of Item.
 */
@AndroidEntryPoint
class ImageDetailFragment : Fragment() {

    private var selectedPosition = 0

    private var _binding: FragmentImageDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: ImageDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           selectedPosition = it.getInt(SelectedPositionKey)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        binding.viewpager.apply {
            adapter = ImageDetailsViewPagerAdapter(mutableListOf())
            this.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            currentItem = selectedPosition
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState->
                    when(uiState){
                        is DetailImageUiState.LOADED -> {
                            binding.waitMsgView.visibility = View.GONE
                            binding.viewpager.apply {
                                visibility = View.VISIBLE
                                (adapter as ImageDetailsViewPagerAdapter).submitItems(uiState.allImageList)
                                setCurrentItem(selectedPosition, false)
                            }
                        }
                        DetailImageUiState.UNINITIALIZED -> {
                            binding.viewpager.visibility = View.INVISIBLE
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