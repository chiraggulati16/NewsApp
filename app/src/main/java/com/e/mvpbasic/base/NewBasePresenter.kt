package com.e.mvpbasic.base

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.streetlogix.db.Api
import com.streetlogix.db.NetworkModule
import io.reactivex.disposables.CompositeDisposable
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

abstract class NewBasePresenter<T>(view: T) {

    var view: T
        internal set

    protected var api: Api? = null
    protected var mCompositeDisposable: CompositeDisposable? = null

    init {
        this.view = view
        api = NetworkModule().providePlacesAPI()

        mCompositeDisposable = CompositeDisposable()
    }

    abstract fun onViewCreated()

    abstract fun onViewDestroyed()


    @Throws(JSONException::class)
    protected fun jsonToMap(t: String?): HashMap<String, Any> {

        val map = HashMap<String, Any>()
        val jObject = JSONObject(t)
        val keys = jObject.keys()

        while (keys.hasNext()) {
            val key = keys.next() as String
            val value = jObject.getString(key)
            map[key] = value
        }

        return map
    }


    fun onReceiveError(error: Throwable) {
        //(view as BaseView).onLoading(false)

        try {
            error.printStackTrace()

            Log.d("error ===",error.message+" ")
            if (error is HttpException) {

                when (error.code()) {
                    401 -> {
                        //     (view as BaseView).onError(R.string.you_are_logout_from_the_app)

                    }
                    500 -> {
                        //   (view as BaseView).onError(R.string.server_error_please_contact_developer)

                    }
                    else -> {


                    }
                }
            }
            else
            {
                //  (view as BaseView).onError(R.string.internet_not_available)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            //  (view as BaseView).onError(R.string.internet_not_available)
        }
    }

    protected fun isInternetAvailable(): Boolean {

        val cm = (view as BaseView).getContext()
            ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected

    }
}