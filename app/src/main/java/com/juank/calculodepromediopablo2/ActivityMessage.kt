package com.juank.calculodepromediopablo2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ActivityMessage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val message= findViewById<TextView>(R.id.message)
        val miBundle: Bundle? = this.intent.extras

        if(miBundle != null) {
            message.text = "Alumno: ${miBundle.getString("editnombreTxt")} \n materia: ${miBundle.getString("editmateria")} \n nota1: ${miBundle.getDouble("nota1")} \n nota2: ${miBundle.getDouble("nota1")} \n nota3: ${miBundle.getDouble("nota3")} \n promedio: ${miBundle.getDouble("promedio")} "
        }
        val respuesta=findViewById<TextView>(R.id.respuesta)
        if(miBundle?.getString("promedio")!! >= 3.5.toString()){
            respuesta.text="${miBundle?.getString("message")}"
            respuesta.setTextColor(Color.parseColor("#4CAF50"))
        }else{
            respuesta.text="${miBundle?.getString("message")}"
            respuesta.setTextColor(Color.parseColor("#C62828"))
        }

    }

}