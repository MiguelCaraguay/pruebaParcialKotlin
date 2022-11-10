package com.example.pruebaparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var extras = intent.extras
        var titulo = extras?.getString("titulo")?:"sin nombre"
        var mensaje = extras?.getString("mensaje")?:"error"
        var img = extras?.getInt("img")?:R.drawable.perro


        tv_msg1.setText(titulo)
        img_content.setBackgroundResource(img)
        tv_msg2.setText(mensaje)

        btn_home.setOnClickListener{
            val irA = Intent(this, MainActivity::class.java)
            startActivity(irA)
        }

    }
}