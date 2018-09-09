package com.no1.taiwan.comicbooker.features.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.no1.taiwan.comicbooker.R
import com.no1.taiwan.comicbooker.bases.AdvActivity
import com.no1.taiwan.comicbooker.bases.LoadView
import com.no1.taiwan.comicbooker.ext.observe
import com.no1.taiwan.comicbooker.ext.peelResponse
import kotlinx.android.synthetic.main.activity_main.navigation

class MainActivity : AdvActivity<MainViewModel>(), LoadView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    override fun showLoading() {
    }

    /**
     * Hide a loading view.
     */
    override fun hideLoading() {
    }

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    override fun showRetry() {
    }

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    override fun hideRetry() {
    }

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    override fun showError(message: String) {
    }

    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_library -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_book -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_account -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun init(savedInstanceState: Bundle?) {
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        vm.fetchTest()
        observe(vm.test) {
            it.peelResponse(this) {

            }
        }
    }

    override fun provideLayoutId() = R.layout.activity_main
}
