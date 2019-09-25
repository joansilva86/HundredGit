package com.example.hundred

import org.json.JSONObject

data class Item (var title: String="",var author:String="",var imageUrl:String= "") {

    fun fillWith(json: JSONObject){
        if (json.has("title")) title = json.getString("title")
        if (json.has("author")) author = json.getString("author")
        if (json.has("imageURL")) imageUrl = json.getString("imageURL")
    }
}