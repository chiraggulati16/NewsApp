package com.e.mvpbasic.base

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<T> : Fragment(), BaseView {

    private var mRootView: View? = null

    protected var mPresenter: T? = null

    abstract fun getLayoutID(): Int

    abstract fun getPresenter(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

        mPresenter = getPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        if (mRootView != null) {
            if (mRootView!!.parent != null) {
                val parent = mRootView!!.parent as ViewGroup
                parent.removeView(mRootView)
            }
        } else {
            mRootView = inflater.inflate(getLayoutID(), container, false)
        }

        return mRootView
    }

    override fun onValidationError(message: String?) {

    }

    override fun onValidationError(messageRes: Int) {

    }

    override fun onLoading(isShow: Boolean) {

    }

    override fun onLoading(isShow: Boolean, progress: Int) {

    }

    override fun onException(exception: Exception) {

    }

    override fun onError(message: String?) {

    }

    override fun onError(resID: Int) {

    }

    override fun onSuccess(message: String?) {

    }

    override fun onSuccess(resID: Int) {

    }

    override fun onFailure() {

    }
}