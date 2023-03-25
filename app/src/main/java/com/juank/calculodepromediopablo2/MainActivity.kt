package com.juank.calculodepromediopablo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val botonCalcular:Button = findViewById(R.id.btnCalcular)
        botonCalcular.setOnClickListener{Calcular()}

    }

    private fun Calcular() {
        val campoNota1: EditText = findViewById(R.id.nota1)
        val campoNota2: EditText = findViewById(R.id.nota2)
        val campoNota3: EditText = findViewById(R.id.nota3)
        val campoTexto: EditText = findViewById(R.id.editnombreTxt)
        val campoMateria1: EditText = findViewById(R.id.editmateria)

        val nota1:Double = campoNota1.text.toString().toDouble()
        val nota2:Double = campoNota2.text.toString().toDouble()
        val nota3:Double = campoNota3.text.toString().toDouble()
        val name:String = campoTexto.text.toString()
        val subject:String = campoMateria1.text.toString()

        val prom: Double = (nota1 + nota2 + nota3) / 3.0
        val Formato = String.format("%.2f", prom)

        var message: String? = null

        if (prom >= 3.5) {
            message = "Aprobado"
        } else {
            message = "Reprobado"
        }

        val intent = Intent(this, ActivityMessage::class.java)
        val content: Bundle = Bundle()
        content.putString("Nombre", name)
        content.putString("Materia", subject)
        content.putString("Promedio", Formato)
        content.putDouble("Nota1",nota1)
        content.putDouble("Nota2",nota2)
        content.putDouble("Nota3",nota3)
        content.putString("message",message)

        intent.putExtras(content)
        startActivity(intent)
    }

}

}