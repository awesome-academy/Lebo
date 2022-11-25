package com.atom.android.lebo.ui.home

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.atom.android.lebo.R
import com.atom.android.lebo.base.BaseFragment
import com.atom.android.lebo.databinding.FragmentHomeBinding
import com.atom.android.lebo.ui.home.adapter.ListAdapterAuthor
import com.atom.android.lebo.ui.home.adapter.ListAdapterBook
import com.atom.android.lebo.ui.home.adapter.ListAdapterGenre
import com.atom.android.lebo.ui.home.adapter.SliderAdapter
import com.atom.android.lebo.utils.constants.Constant
import com.atom.android.lebo.utils.extensions.hasItem
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel by viewModel<HomeViewModel>()

    private val genreAdapter by lazy { ListAdapterGenre({}) }
    private val bookAdapter by lazy {
        ListAdapterBook { book ->
            val action = HomeFragmentDirections
                .actionNavigationHomeToNavigationDetail(book.id.toString())
            findNavController().navigate(action)
        }
    }
    private val sliderAdapter by lazy { SliderAdapter() }
    private val authorAdapter by lazy { ListAdapterAuthor({}) }

    override fun initData() {
        viewModel.getGenre()
        viewModel.getBook()
        viewModel.getSlider()
        viewModel.getAuthor()
    }

    override fun initView() {
        binding.apply {
            recyclerViewCategory.adapter = genreAdapter
            recyclerViewBook.adapter = bookAdapter
            recyclerViewAuthor.adapter = authorAdapter
            sliderView.apply {
                setIndicatorAnimation(IndicatorAnimationType.WORM)
                setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
                startAutoCycle()
            }
            sliderView.setSliderAdapter(sliderAdapter)
        }

        viewModel.apply {
            genre.observe(viewLifecycleOwner) {
                genreAdapter.submitList(it.hasItem())
            }

            books.observe(viewLifecycleOwner) {
                bookAdapter.submitList(it.hasItem())
            }

            slides.observe(viewLifecycleOwner) {
                sliderAdapter.submitList(it)
            }

            author.observe(viewLifecycleOwner) {
                authorAdapter.submitList(it.hasItem())
            }

            swipeRefreshState.observe(viewLifecycleOwner) {
                binding.swipeRefreshLayout.isRefreshing = false
                binding.swipeRefreshLayout.isEnabled = true
                binding.sliderView.setSliderAdapter(sliderAdapter)
                binding.recyclerViewBook.smoothScrollToPosition(Constant.DEFAULT.POSITION)
                binding.recyclerViewAuthor.smoothScrollToPosition(Constant.DEFAULT.POSITION)
            }
        }
    }

    override fun initEvent() {
        binding.apply {
            swipeRefreshLayout.setOnRefreshListener {
                swipeRefreshLayout.isEnabled = false
                viewModel.refreshData(context)
            }
        }
        bookAdapter.loadMore(binding.recyclerViewBook) { viewModel.getBook() }
    }
}
