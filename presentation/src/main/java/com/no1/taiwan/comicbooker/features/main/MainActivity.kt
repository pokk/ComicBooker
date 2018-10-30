package com.no1.taiwan.comicbooker.features.main

import android.os.Bundle
import com.devrapid.kotlinknifer.loge
import com.devrapid.kotlinknifer.logw
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.no1.taiwan.comicbooker.R
import com.no1.taiwan.comicbooker.bases.AdvActivity
import com.no1.taiwan.comicbooker.ext.doWith
import com.no1.taiwan.comicbooker.ext.happenError
import com.no1.taiwan.comicbooker.ext.observeNonNull
import com.no1.taiwan.comicbooker.ext.peel
import kotlinx.android.synthetic.main.activity_main.btn_click
import kotlinx.android.synthetic.main.activity_main.et_input1
import kotlinx.android.synthetic.main.activity_main.et_input2
import kotlinx.android.synthetic.main.activity_main.navigation
import kotlinx.android.synthetic.main.activity_main.tv_res

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
        observeNonNull(vm.test) {
            peel { logw(it) } happenError { loge(it) } doWith this@MainActivity
        }

//        observeNonNull(vm.bookers) {
//            peel { logw(it) } happenError { loge(it) } doWith this@MainActivity
//        }

        btn_click.setOnClickListener {
            val s = "${et_input1.text} + ${et_input2.text}"

            tv_res.text = s
        }
    }

    override fun onResume() {
        super.onResume()

        vm.fetchTest()
//        vm.fetchBooker()
    }

    override fun provideLayoutId() = R.layout.activity_main
}
