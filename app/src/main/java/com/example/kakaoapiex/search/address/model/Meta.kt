package com.example.kakaoapiex.search.address.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("is_end")
    val isEnd: Boolean?,
    @SerializedName("pageable_count")
    val pageableCount: Int?,
    @SerializedName("total_count")
    val totalCount: Int?
)