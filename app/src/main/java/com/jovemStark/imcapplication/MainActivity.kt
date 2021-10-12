package com.jovemStark.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main_relative.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_linear)
        setListeners()
    }

    private fun setListeners(){
        pesoEDT?.doOnTextChanged { text, _, _, _ ->

            alturaEDT?.doAfterTextChanged { text ->
                //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
            }


            calcularBTN.setOnClickListener{
                calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
            }
        }
    }
    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null){
            val imc = peso / (altura * altura)
            titleTXT.text =   "O seu IMC é: %.2f".format(imc)
        }
    }

}