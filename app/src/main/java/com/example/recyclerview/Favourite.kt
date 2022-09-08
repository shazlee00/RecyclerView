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


class Favourite : Fragment(R.layout.fragment_favourite) {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: FavouriteRecyclerAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.favouriteRecyclerView)

        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        if (adapter == null)
            adapter = FavouriteRecyclerAdapter(listOf())
        recyclerView.adapter = adapter




    }


}