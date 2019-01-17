package com.ewerton.apistarwars

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.ewerton.apistarwars.adapter.FilmAdapter
import com.ewerton.apistarwars.api.BaseAPI
import com.ewerton.apistarwars.model.Film
import com.ewerton.apistarwars.model.Films
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var adapter : FilmAdapter? = null
    private var filmList : ArrayList<Film>? = null
    private var layoutManager : RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Lista de Filmes"


        filmList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = FilmAdapter(filmList!!, this)


        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        val call = BaseAPI().apiStarWars().getFilms()
        call.enqueue(object : Callback<Films> {
            override fun onFailure(call: Call<Films>, e: Throwable?) {
                Log.e("Erro: ", e.toString())
            }

            override fun onResponse(call: Call<Films>, response: Response<Films>) {

                recyclerView.adapter = FilmAdapter(response.body()!!.results, applicationContext)
            }

        })


        adapter!!.notifyDataSetChanged()
    }
}
