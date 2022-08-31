package com.example.kakaoapiex.search.image.model


import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("documents")
    val documents: List<Document?>?,
    @SerializedName("meta")
    val meta: Meta?
)