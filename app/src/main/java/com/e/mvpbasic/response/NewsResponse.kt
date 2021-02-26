package com.e.mvpbasic.response

import com.google.gson.annotations.SerializedName

class NewsResponse {

    @SerializedName("status")
    var status : String = ""

    @SerializedName("totalResults")
    var totalResult: String = ""

    @SerializedName("articles")
    lateinit var articleList : ArrayList<ArticlesResponse>
}