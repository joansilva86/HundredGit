package com.example.hundred

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_template_recycler.view.*


class AdapterCustom() :
    RecyclerView.Adapter<AdapterCustom.ViewHolderCustom>() {

    var list:List<Item> = ArrayList()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCustom {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_template_recycler, parent, false)
        return ViewHolderCustom(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderCustom, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolderCustom(private var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {
            this.view.txtFirst.text = item.one
            this.view.txtSecond.text = item.two
            this.view.txtThree.text = item.three
        }
    }

}