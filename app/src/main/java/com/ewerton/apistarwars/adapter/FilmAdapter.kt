package com.ewerton.apistarwars.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ewerton.apistarwars.R
import com.ewerton.apistarwars.film.FilmActivity
import com.ewerton.apistarwars.model.Film
import kotlinx.android.synthetic.main.list_item.view.titulo
import kotlinx.android.synthetic.main.list_item.view.picView

class FilmAdapter(private val list: ArrayList<Film>, private val context: Context):

    RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FilmAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(film: Film){

            itemView.titulo.text = film.title
            itemView.picView.setImageResource(R.mipmap.ic_launcher_round)
            //itemView.descricao.text = film.opening_crawl

            itemView.setOnClickListener{
                //Toast.makeText(context, itemView.titulo.text, Toast.LENGTH_LONG).show()
               var filmArr = arrayOf(film.title, film.opening_crawl)
                val intent = Intent(context, FilmActivity::class.java)
                intent.putExtra("filmArr", filmArr)
                context.startActivity(intent)
            }
        }
    }
}