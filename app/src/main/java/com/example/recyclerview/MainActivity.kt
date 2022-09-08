package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    //private var layoutManager:RecyclerView.LayoutManager?=null
    //private var adapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navBar: BottomNavigationView = findViewById(R.id.nav_bar)

        var navHostController=findNavController(R.id.fragmentContainerView)
        navBar.setupWithNavController(navHostController)
    }
    }



    /*val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
       adapter=RecyclerAdapter()

        recyclerView.adapter = adapter

    }*/


