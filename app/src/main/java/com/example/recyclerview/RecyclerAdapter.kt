package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerAdapter(var items:List<Articles?>?): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    class ViewHolder(view:View): RecyclerView.ViewHolder(view)
    {
         var itemImage: ImageView
         var itemText: TextView
         var itemDetail:TextView
         var favCheckBox: CheckBox
         init {
             itemImage=view.findViewById(R.id.item_image )
             itemText=view.findViewById(R.id.item_text )
             itemDetail=view.findViewById(R.id.item_detail )
             favCheckBox=view.findViewById(R.id.checkBox)


         }

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val view=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val articles=items?.get(position)

        Glide.with(holder.itemView).load(articles?.urlToImage).into(holder.itemImage)

        holder.itemText?.text=articles?.title

        holder.itemDetail?.text=articles?.description

        holder.itemText.setOnClickListener{
            val context=holder.itemText.context
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(articles?.url)
            context.startActivity(intent)
        }

        holder.favCheckBox.setOnClickListener{
            
        }


    }

    override fun getItemCount(): Int {
       return items?.size?:0
    }
}