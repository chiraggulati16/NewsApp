package com.e.mvpbasic.response

import com.google.gson.annotations.SerializedName

class ArticlesResponse {

    @SerializedName("author")
    var author : String = ""

    @SerializedName("title")
    var title : String = ""

    @SerializedName("description")
    var description : String = ""

    @SerializedName("url")
    var url : String = ""

    @SerializedName("urlToImage")
    var urlToImage : String = ""

    @SerializedName("publishedAt")
    var publishedAt : String = ""

    @SerializedName("content")
    var content : String = ""
}