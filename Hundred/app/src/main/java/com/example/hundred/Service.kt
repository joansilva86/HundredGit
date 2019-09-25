package com.example.hundred

import android.util.Log
import com.android.volley.Response
import org.json.JSONArray


open class Service {

    fun getArrayResponseListener(responseListener: ServiceArrayResponseListener?, errorListener: ServiceErrorListener?): Response.Listener<JSONArray> {
        return Response.Listener { response ->
            if (BuildConfig.DEBUG) Log.i("RESPONSE", response.toString())
            responseListener?.serviceResponse(response)
        }
    }

    fun getErrorListener(errorListener: ServiceErrorListener?): Response.ErrorListener {
        return Response.ErrorListener { error ->
            if (BuildConfig.DEBUG) Log.i("ERROR", error.toString())
            var code = 400
            try {
                code = error.networkResponse.statusCode
            } catch (e: Exception) {

            }
            errorListener?.serviceError(code)
        }
    }


    interface ServiceErrorListener {
        fun serviceError(code: Int)
    }

    interface ServiceArrayResponseListener {
        fun serviceResponse(jsonArray: JSONArray?)
    }
}