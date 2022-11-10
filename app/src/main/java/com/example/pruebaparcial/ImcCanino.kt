package com.example.pruebaparcial


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_imc.*


class ImcCanino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        ArrayAdapter.createFromResource(
            this,
            R.array.genero_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sp_genero.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.raza_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            sp_raza.adapter = adapter
        }


        btn_submit.setOnClickListener{
            try {
            var peso = et_peso_corporal.text.toString().toDouble()
            var altura= et_altura.text.toString().toDouble()
            var occ = et_occ.text.toString().toDouble()
            var nombre = et_nombre.text.toString()
            val genero = sp_genero.selectedItem.toString()
            val raza = sp_raza.selectedItem.toString()
            val cp = et_cp.text.toString().toDouble()


            var imc = 0.0

            if (genero == "Hembra"){
                imc =(-1.7 * altura) + (0.93*cp) +5
            }
                imc =  (-1.4 * altura) + (0.7*cp)+4

            var titulo = "El IMC de $nombre es $imc "

            val mini = intArrayOf(1, 6)
            val pequenia = intArrayOf(7, 15)
            val medianas = intArrayOf(14, 27)
            val grandes = intArrayOf(25, 39)
            val gigantes = intArrayOf(34, 82)
            var aux = intArrayOf(1,6)

            when (genero){
            "mini"->{
                aux = intArrayOf(1,6)

            }
            "pequeña"->{
                aux = intArrayOf(7, 15)
                println("peque;a")
            }
            "mediana"->{
                aux = intArrayOf(14, 27)

            }
            "grande"->{
                aux = intArrayOf(25, 39)

            }
            "gigante"->{
                aux = intArrayOf(34, 82)

            }
            }
            var mensaje = ""
            var img = R.drawable.perro
            if (imc < aux[0]){
                mensaje = "Peso Bajo"
                var img = R.drawable.perro_desnutrido
            }else if (imc > aux[1]){
                mensaje = "Sobre Peso"
                var img = R.drawable.obeso
            }else{
                mensaje = "Peso Normal"
                var img = R.drawable.perro_normal
            }



            val irA = Intent(this, Resultado::class.java)

            irA.putExtra("titulo",titulo)
            irA.putExtra("mensaje",mensaje)
            irA.putExtra("img",img)


            startActivity(irA)
            }catch (e: NumberFormatException){
                Toast.makeText(applicationContext, "Ponga datos", Toast.LENGTH_SHORT).show()
            }

        }

    }
}