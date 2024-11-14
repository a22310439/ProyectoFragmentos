package com.example.fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class DataFragment : Fragment() {

    private lateinit var txtInfo: EditText
    private lateinit var btnEnviar: Button
    private lateinit var callback: DataListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_data, container, false)
        txtInfo = view.findViewById(R.id.txtInfo)
        btnEnviar = view.findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val infoEnviar = txtInfo.text.toString()
                callback.enviarInfo(infoEnviar)
            }
        })
        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = try{
            context as DataListener
        }catch (ex: Exception){
            throw ClassCastException(context.toString()
            + "Se debe implementar la intergaz DataListener")
        }
    }

    interface DataListener{
        fun enviarInfo(info: String)
    }

}