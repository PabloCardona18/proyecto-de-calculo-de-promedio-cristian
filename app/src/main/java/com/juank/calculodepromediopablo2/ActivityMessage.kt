package com.juank.calculodepromediopablo2

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityMessage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val message= findViewById<TextView>(R.id.textMessage)
        val miBundle: Bundle? = this.intent.extras

        if(miBundle != null) {
            message.text = "Alumno: ${miBundle.getString("Nombre")} \n materia: ${miBundle.getString("Materia")} \n nota1: ${miBundle.getDouble("Nota1")} \n nota2: ${miBundle.getDouble("Nota2")} \n nota3: ${miBundle.getDouble("Nota3")} \n promedio: ${miBundle.getDouble("Promedio")} "
        }
        val respuesta=findViewById<TextView>(R.id.respuesta)

        if(miBundle?.getString("Promedio")!! >= 3.5.toString()){
            respuesta.text=" ${miBundle?.getString("message")}"
            respuesta.setTextColor(Color.parseColor("#4CAF50"));
        }else{
            respuesta.text=" ${miBundle?.getString("message")}"
            respuesta.setTextColor(Color.parseColor("#C62828"));

        }
    }

}