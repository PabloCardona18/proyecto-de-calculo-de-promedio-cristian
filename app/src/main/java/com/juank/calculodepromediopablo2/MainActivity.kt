package com.juank.calculodepromediopablo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botoncalcular: Button=findViewById(R.id.btnCalcular)
        botoncalcular.setOnClickListener{realizarCalculo()}

    }

    private fun realizarCalculo() {

        val campoNombre:EditText=findViewById(R.id.editnombreTxt)
        val campoMateria:EditText=findViewById(R.id.editmateria)

        val campoNota1:EditText=findViewById(R.id.nota1)
        val campoNota2:EditText=findViewById(R.id.nota2)
        val campoNota3:EditText=findViewById(R.id.nota3)


        val nombre:String=campoNombre.text.toString()
        val materia:String=campoMateria.text.toString()
        val nota1:Double=campoNota1.text.toString().toDouble()
        val nota2:Double=campoNota2.text.toString().toDouble()
        val nota3:Double=campoNota3.text.toString().toDouble()


        val prom:Double=(nota1+nota2+nota3)/3
        var messagepro: String? = null

        if(prom >= 3.5){
            messagepro = "Usted ha aprobado"
        }else{
            messagepro = "Usted no aprobo"
        }

        val llamar = Intent(this, ActivityMessage::class.java )
        val conteiner: Bundle = Bundle()
        conteiner.putString("editnombreTxt", nombre)
        conteiner.putString("editmateria", materia )
        conteiner.putDouble("promedio", prom)
        conteiner.putDouble("nota1", nota1)
        conteiner.putDouble("nota2", nota2)
        conteiner.putDouble("nota3", nota3)
        conteiner.putString("message",messagepro)

        llamar.putExtras(conteiner)
        startActivity(llamar)






    }
}