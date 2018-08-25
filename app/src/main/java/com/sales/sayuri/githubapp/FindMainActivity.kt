package com.sales.sayuri.githubapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sales.sayuri.githubapp.api.GitHubService
import com.sales.sayuri.githubapp.api.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_find_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FindMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_main)

        btPesquisar.setOnClickListener{
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create(GitHubService::class.java)
            service.buscarUsuario(etUsername.text.toString())
                    .enqueue(object : Callback<Usuario> {
                        override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                            Toast.makeText(this@FindMainActivity,
                                    "Deu ruim",
                                    Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                            val usuario = response?.body()
                            Picasso.get()
                                    .load(usuario?.avatarURL)
                                    .into(ivFoto)
                            tvNome.text = usuario?.nome
                        }

                    })

        }

    }
}
