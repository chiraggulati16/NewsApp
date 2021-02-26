package com.streetlogix.db

import com.e.mvpbasic.BuildConfig
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class NetworkModule {

    fun providePostAPI(): Api {
        val retrofit = provideRetrofitInterface(BuildConfig.BASE_URL)
        return retrofit.create(Api::class.java)
    }

    fun providePlacesAPI(): Api {
        val retrofit = provideRetrofitInterface("https://maps.googleapis.com/")
        return retrofit.create(Api::class.java)
    }

    private fun provideRetrofitInterface(url: String): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
            .readTimeout(50, TimeUnit.SECONDS)
            .connectTimeout(50, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

}