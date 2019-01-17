package com.ewerton.apistarwars.film

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ewerton.apistarwars.R
import kotlinx.android.synthetic.main.activity_film.*

class FilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)
        supportActionBar!!.title = "Detalhes"
        val film = intent.getStringArrayExtra("filmArr")

        titulo.text =if(film!=null) "Título: "+film[0] else "Sem título"
        descricao.text =if(film!=null) "Descrição: "+film[1] else "Sem descricao"
        imageView.setImageResource(R.drawable.logo)
    }

}
