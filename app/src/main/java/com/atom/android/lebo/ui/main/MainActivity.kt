package com.atom.android.lebo.ui.main

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.atom.android.lebo.R
import com.atom.android.lebo.base.BaseActivity
import com.atom.android.lebo.databinding.ActivityMainBinding
import com.atom.android.lebo.utils.extensions.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel by viewModel<MainViewModel>()

    private val navController by lazy { findNavController(R.id.nav_host_fragment_activity_main) }

    override fun initData() {
        // late impl
    }

    override fun handleEvent() {
        viewModel.hasError.observe(this) {
            showToast(it)
        }
    }

    override fun bindData() {
        setupWithNavController(binding.navView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> setNavigationVisible(true)
                R.id.navigation_library -> setNavigationVisible(true)
                R.id.navigation_favorite -> setNavigationVisible(true)
                R.id.navigation_account -> setNavigationVisible(true)
                else -> setNavigationVisible()
            }
        }
    }

    private fun setNavigationVisible(isVisible: Boolean = false) {
        binding.navView.isVisible = isVisible
    }
}
