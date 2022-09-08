package com.example.recyclerview

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FavouriteRecyclerAdapter(var items:List<FavouriteArticles?>?):RecyclerView.Adapter<FavouriteRecyclerAdapter.ViewHolder>()
{
    class ViewHolder(view:View): RecyclerView.ViewHolder(view)
    {
        var itemImage: ImageView
        var itemText: TextView
        var itemDetail:TextView

        init {
            itemImage=view.findViewById(R.id.item_image )
            itemText=view.findViewById(R.id.item_text )
            itemDetail=view.findViewById(R.id.item_detail )
        }


    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FavouriteRecyclerAdapter.ViewHolder {

        val view=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)


        return FavouriteRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteRecyclerAdapter.ViewHolder, position: Int) {

        val articles = items?.get(position)

        Glide.with(holder.itemView).load(articles?.urlToImage).into(holder.itemImage)

        holder.itemText?.text = articles?.title

        holder.itemDetail?.text = articles?.description

        holder.itemText.setOnClickListener {
            val context = holder.itemText.context
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(articles?.url)
            context.startActivity(intent)
        }


        }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

}



}