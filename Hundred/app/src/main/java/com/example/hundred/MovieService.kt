package com.example.hundred

import android.content.Context
import android.util.Log


class MovieService : Service() {

    fun getMovies(context : Context, responseListener: ServiceArrayResponseListener, errorListener: ServiceErrorListener) {

        val url = "http://de-coding-test.s3.amazonaws.com/books.json"
        if (BuildConfig.DEBUG) Log.i("SERVICE", url)

        val headers = java.util.HashMap<String, String>()

        if (BuildConfig.DEBUG) Log.i("HEADERS", headers.toString())

        val request = VolleySingleton.getInstance(context).getArrayRequest(
            url,
            headers,
            getArrayResponseListener(responseListener, errorListener),
            getErrorListener(errorListener)
        )
        VolleySingleton.getInstance(context).requestQueue.add(request)
    }

}