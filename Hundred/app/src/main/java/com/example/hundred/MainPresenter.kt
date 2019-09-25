package com.example.hundred

import android.content.Context
import org.json.JSONArray

class MainPresenter {
    var list = ArrayList<Item>()
    private var view : MainView? = null

    fun attach(view: MainView) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }

    fun getMovies(context: Context){
        MovieService().getMovies(context,onResponseListener,onServiceError)
    }

    private val onResponseListener = object : Service.ServiceArrayResponseListener{
        override fun serviceResponse(jsonArray: JSONArray?) {
            list.clear()
            val a = jsonArray?.let {
                for (i in 0 until it.length()){
                    val jsonMovie = it.getJSONObject(i)
                    var movie = Item()
                    movie.fillWith(jsonMovie)
                    list.add(movie)
                }
            }
            view?.showList(list)
        }
    }

    private var onServiceError = object : Service.ServiceErrorListener {
        override fun serviceError(code: Int) {
            view?.showError()
        }
    }
}

interface MainView {
    fun showError()
    fun showList(list: ArrayList<Item>)
}