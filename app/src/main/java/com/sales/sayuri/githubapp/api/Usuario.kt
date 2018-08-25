package com.sales.sayuri.githubapp.api

import com.google.gson.annotations.SerializedName

data class Usuario (
        @SerializedName("name") val nome:String,
        @SerializedName("avatar_url") val avatarURL: String)

