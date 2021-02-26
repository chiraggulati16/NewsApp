package com.e.mvpbasic.ui.news

import android.util.Log
import com.e.mvpbasic.BuildConfig
import com.e.mvpbasic.R
import com.e.mvpbasic.base.BasePresenter
import com.e.mvpbasic.response.NewsResponse
import com.google.gson.Gson
import com.streetlogix.db.Endpoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

class NewsPresenter(view: NewsView): BasePresenter<NewsView>(view) {

    override fun onViewCreated() {

    }

    override fun onViewDestroyed() {
        mCompositeDisposable?.clear()
    }

    fun getNews() {

        var params = ""
        params += "country=us"


        params += "&apiKey=${BuildConfig.API_KEY}"

        params = params.removeSurrounding("&", "")

        var url = Endpoint.News.TOP_HEADLINES+"?${params}"
        if (isInternetAvailable()) {
            view.onLoading(true)
            mCompositeDisposable?.add(
                api!!.doApiCall(
                    url
                )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::onReceiveResponse, this::onReceiveError)
            )
        } else {
            view.onValidationError(R.string.internet_not_available)
        }
    }

    private fun onReceiveResponse(responseBody: ResponseBody) {

        view.onLoading(false)

        val string = responseBody.string()

        val response = Gson().fromJson(string, NewsResponse::class.java)

        Log.d("response ===", response.articleList.toString())
        view.onNewsList(response.articleList)
    }
}