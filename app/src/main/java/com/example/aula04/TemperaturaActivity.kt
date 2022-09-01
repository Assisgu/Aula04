package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.aula04.databinding.ActivityTemperaturaBinding
//import kotlinx.android.synthetic.main.activity_temperatura.*

class TemperaturaActivity : AppCompatActivity() {

    lateinit var binding: ActivityTemperaturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_temperatura)
        setContentView(binding.root)

        /*
              Tipos de binding
                findViewById
                kotlinAndroidExtensions
                viewBinding automatico (recomendado)
        */

//        val tempValor: EditText = findViewById(R.id.tempValor)
//        val radioGrupTemp: RadioGroup = findViewById(R.id.radioGrupTemp)
//        val textResultado: EditText = findViewById(R.id.textResultado)
//        val buttonConverter: Button = findViewById(R.id.buttonConverter)


        //Clogger ou Listener (evento para executar quando clicar)
        binding.buttonConverter.setOnClickListener {
            if (binding.tempValor.text.isNotEmpty()) {
                val valor = binding.tempValor.text.toString().toFloat()

                var resultado: Float

                when (binding.radioGrupTemp.checkedRadioButtonId) {
                    R.id.radioK -> {
                        resultado = valor + 273
                        binding.textResultado.setText(resultado.toString() + "ºK")
                    }

                    R.id.radioF -> {
                        resultado = (valor * 1.8 + 32).toFloat()
                        binding.textResultado.setText(resultado.toString() + "ºF")
                    }

                    else -> {
                        binding.textResultado.setText("Selecione uma temperatura abaixo")
                    }
                }
            } else {
                binding.textResultado.setText("Digite um valor de temperatura")
            }

        }

    }
}