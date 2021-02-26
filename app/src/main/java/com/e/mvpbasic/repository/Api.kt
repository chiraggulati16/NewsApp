package com.streetlogix.db

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface Api {

    @GET()
    fun doApiCall(
        @Url url: String
    ): Observable<ResponseBody>


}