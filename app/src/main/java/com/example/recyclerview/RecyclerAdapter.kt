package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximeroussy.invitrode.WordGenerator
import kotlin.random.Random

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var generator: WordGenerator = WordGenerator()


    private var detail= arrayOf(generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)))
    private var titles= arrayOf(generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)),generator.newWord(Random.nextInt(0, 30)))
    private var imgSrc=arrayOf("https://picsum.photos/200/200","https://picsum.photos/200/200","https://picsum.photos/200/200","https://picsum.photos/200/200","https://picsum.photos/200/200",
        "https://picsum.photos/200/100",
        "https://picsum.photos/200",
        "https://picsum.photos/100/200",
        "https://picsum.photos/100/100",
        "https://picsum.photos/200/200",
        "https://picsum.photos/200/200"
    )

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


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val view=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.itemText.text=titles[position]
        holder.itemDetail.text=detail[position]
        Glide.with(holder.itemView)
            .load(imgSrc[position])
            .into(holder.itemImage!!)


    }

    override fun getItemCount(): Int {
       return titles.size
    }
}