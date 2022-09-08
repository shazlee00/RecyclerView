package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment(R.layout.fragment_home) {

       private  var layoutManager:RecyclerView.LayoutManager?=null
       private  var adapter: RecyclerAdapter? =null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView=view.findViewById<RecyclerView>(R.id.recyclerView)

        layoutManager= LinearLayoutManager(context)
        recyclerView.layoutManager=layoutManager
        if(adapter == null )
        adapter=RecyclerAdapter(listOf())
        recyclerView.adapter = adapter


        getEverything()

    }

    private fun getEverything() {

        service.everything("Tech","29070b6383184ff581b302670bbc02b4").enqueue(
           object:Callback<Everything>{
               override fun onResponse(call: Call<Everything>, response: Response<Everything>) {

                   if(response.isSuccessful)
                   {

                       adapter?.items=response.body()?.articles
                       adapter?.notifyDataSetChanged()


                   }

               }

               override fun onFailure(call: Call<Everything>, t: Throwable) {
                Toast.makeText(context,t.localizedMessage,Toast.LENGTH_LONG).show()
               }

           }
        )

    }


}