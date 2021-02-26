package com.e.mvpbasic.base

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.e.mvpbasic.R

abstract class BaseActivity : AppCompatActivity() {

    private val mHandler = Handler()

    protected abstract fun getLayoutID(): Int

    protected abstract fun getInitialFragment(): Fragment?

    protected abstract fun getInitialTag(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutID())

        if (getInitialFragment() != null) {
            swapFragment(getInitialFragment()!!, getInitialTag(), false)
        }
    }

    fun swapFragment(newFragment: Fragment, tag: String, addToStack: Boolean) {
        val runnable = Runnable {
            try {
                val fm = supportFragmentManager
                val transaction = fm.beginTransaction()

                transaction.replace(R.id.container, newFragment, tag)

                if (addToStack) {
                    transaction.addToBackStack(tag)
                }

                transaction.commit()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        mHandler.postDelayed(runnable, 1)
    }
}