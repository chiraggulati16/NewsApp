package com.e.mvpbasic.ui.news

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.mvpbasic.R
import com.e.mvpbasic.response.ArticlesResponse

class NewsAdapter(private var articleList: ArrayList<ArticlesResponse>, var context : Context) :
RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

   class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      var title: TextView = view.findViewById(R.id.news_title)
      var description: TextView = view.findViewById(R.id.news_description)
      var image: ImageView = view.findViewById(R.id.news_image)
   }
   @NonNull
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.single_news_layout, parent, false)
      return MyViewHolder(itemView)
   }
   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val article = articleList[position]
      holder.title.text = article.title
      holder.description.text = article.description

      Glide.with(context).load(article.urlToImage).into(holder.image)

   }
   override fun getItemCount(): Int {
      return articleList.size
      Log.d("item count ===",""+ articleList.size)
   }
}