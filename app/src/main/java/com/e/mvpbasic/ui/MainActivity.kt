package com.e.mvpbasic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.e.mvpbasic.R
import com.e.mvpbasic.base.BaseActivity
import com.e.mvpbasic.ui.news.NewsFragment

class MainActivity : BaseActivity() {

    override fun getLayoutID(): Int = R.layout.activity_main

    override fun getInitialFragment() = NewsFragment()


    override fun getInitialTag(): String = "HomeFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}