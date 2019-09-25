package com.example.hundred

import org.json.JSONObject

data class Item (var one: String="",var two:String="",var three:String= "") {

    fun fillWith(json: JSONObject){
        if (json.has("title")) one = json.getString("title")
        if (json.has("author")) two = json.getString("author")
        if (json.has("imageURL")) three = json.getString("imageURL")
    }
}