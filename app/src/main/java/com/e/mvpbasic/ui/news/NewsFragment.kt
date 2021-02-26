package com.e.mvpbasic.ui.news

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.mvpbasic.R
import com.e.mvpbasic.base.BaseFragment
import com.e.mvpbasic.response.ArticlesResponse
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment  : BaseFragment<NewsPresenter>(), NewsView {


    override fun getLayoutID() = R.layout.fragment_news

    override fun getPresenter() = NewsPresenter(this);

    lateinit  var  dialog : Dialog

    lateinit var adapter: NewsAdapter

    var newList : ArrayList<ArticlesResponse> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dialog = Dialog(requireContext())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(R.layout.progress_dialog)
//        dialog.setCanceledOnTouchOutside(false)
//        dialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        showProgress()
        settingAdapter()

        mPresenter?.getNews()

    }

    private fun settingAdapter() {
        news_Recycler.layoutManager = LinearLayoutManager(context)
        adapter = NewsAdapter(newList, context as Context)
        news_Recycler.adapter = adapter
    }

    override fun onNewsList(newsList: ArrayList<ArticlesResponse>) {

        Log.d("article size ===", newsList.toString())
        newList.addAll(newsList)
        adapter.notifyDataSetChanged()
    }

    fun showProgress() {
        dialog.show()
    }

    fun hideProgress() {
        dialog.dismiss()
    }
}