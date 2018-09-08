package com.no1.taiwan.comicbooker.features.main

import android.os.Bundle
import com.devrapid.kotlinknifer.logw
import com.devrapid.kotlinknifer.ui
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.no1.taiwan.comicbooker.R
import com.no1.taiwan.comicbooker.bases.AdvActivity
import kotlinx.android.synthetic.main.activity_main.navigation

class MainActivity : AdvActivity<MainViewModel>() {
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
        launch {
            ui {
                val a = vm.fetchTest()
                logw(a)
            }
        }
    }

    override fun provideLayoutId() = R.layout.activity_main
}
