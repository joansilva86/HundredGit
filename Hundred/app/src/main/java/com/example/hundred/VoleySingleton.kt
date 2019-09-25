package com.example.hundred

import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import java.util.HashMap


class VolleySingleton private constructor(context: Context) {
    private var mRequestQueue: RequestQueue? = null
    private var mCtx: Context? = null
    val imageLoader: ImageLoader
    val requestQueue: RequestQueue
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(mCtx?.applicationContext)
            }
            return this!!.mRequestQueue!!
        }

    //Singleton
    init {
        mCtx = context
        mRequestQueue = requestQueue

        imageLoader = ImageLoader(this.mRequestQueue, object : ImageLoader.ImageCache {
            private val mCache = LruCache<String, Bitmap>(10)
            override fun putBitmap(url: String, bitmap: Bitmap?) {
                mCache.put(url, bitmap)
            }

            override fun getBitmap(url: String): Bitmap? {
                return mCache.get(url)
            }
        })
    }

    companion object {
        private var mInstance: VolleySingleton? = null

        @Synchronized
        fun getInstance(context: Context): VolleySingleton {
            if (mInstance == null) {
                mInstance = VolleySingleton(context)
            }
            return mInstance as VolleySingleton
        }
    }

    //Request
    fun getArrayRequest(url: String, headers: HashMap<String, String>, responseListener: Response.Listener<JSONArray>, errorListener: Response.ErrorListener): JsonArrayRequest {

        return object : JsonArrayRequest(url, responseListener, errorListener) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                return headers
            }
        }
    }

}