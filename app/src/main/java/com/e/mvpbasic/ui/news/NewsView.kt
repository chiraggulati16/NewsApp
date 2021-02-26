package com.e.mvpbasic.ui.news

import com.e.mvpbasic.response.ArticlesResponse

interface NewsView {

    fun onLoading(isLoading : Boolean)

    fun onValidationError(errorMessage: Int)

    fun onNewsList(newsList : ArrayList<ArticlesResponse>)
}