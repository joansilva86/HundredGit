package com.example.hundred

class MainPresenter {
    private var view : MainView? = null

    fun attach(view: MainView) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }
    fun begin(){
        var list = ArrayList<Item>()
        list.add( Item("asdfsad","fas","fsdadfsaasdf"))
        list.add( Item("asdfsad","fas","fsdadfsaasdf"))
        list.add( Item("asdfsad","fas","fsdadfsaasdf"))
        list.add( Item("asdfsad","fas","fsdadfsaasdf"))
        list.add( Item("asdfsad","fas","fsdadfsaasdf"))

    }
}

interface MainView {
    fun ShowError()
    fun ShowList(var list: ArrayList<Item>)
}