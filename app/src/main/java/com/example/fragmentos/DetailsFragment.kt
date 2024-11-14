package com.example.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {

    private lateinit var txtDetalle: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_details, container, false)
        txtDetalle = view.findViewById(R.id.txtDetalle)
        // Inflate the layout for this fragment
        return view
    }

    fun mostrarInfo(info:String){
        txtDetalle.text = info
    }
}