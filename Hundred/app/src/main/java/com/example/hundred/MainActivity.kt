package com.example.hundred

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    private val presenter = MainPresenter()

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter.begin()
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detach()
    }


    override fun showList(list: ArrayList<Item>) {
        (recycler.adapter as AdapterCustom).list = list
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = AdapterCustom()
    }
}
