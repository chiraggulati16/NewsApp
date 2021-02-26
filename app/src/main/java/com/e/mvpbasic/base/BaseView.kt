package com.e.mvpbasic.base

import android.content.Context

interface BaseView {

    fun getContext(): Context?

    fun onValidationError(message: String?)

    fun onValidationError(messageRes: Int)

    fun onLoading(isShow: Boolean)

    fun onLoading(isShow: Boolean, progress: Int)

    fun onException(exception: Exception)

    fun onError(message: String?)

    fun onError(resID: Int)

    fun onSuccess(message: String?)

    fun onSuccess(resID: Int)

    fun onFailure()

}