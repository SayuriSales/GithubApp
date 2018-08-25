package com.sales.sayuri.githubapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{username}")
    fun buscarUsuario(@Path("username")username: String) : Call<Usuario>
}