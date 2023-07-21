package com.awakelab.oskar.ejercicio17kotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.awakelab.oskar.ejercicio17kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val divisas = listOf<String>("USD", "CLP", "EUR")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spUp.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spDown.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        initListener()
    }

    private fun initListener() {
        binding.btnConvert.setOnClickListener {
            val monto = binding.etInsertMonto.text.toString().toDouble()
            val divisaActual: String = binding.spUp.selectedItem.toString()
            val divisaCambio: String = binding.spDown.selectedItem.toString()

            val conversion: Double = convertir(monto, divisaActual, divisaCambio)

            binding.tvMontoConvertido.setText("CAMBIO \nDE    $monto $divisaActual \nA     $conversion $divisaCambio")
                .toString()
        }

        binding.btnReset.setOnClickListener {
            binding.tvMontoConvertido.text = ""
            binding.etInsertMonto.setText("")
        }
    }

    private fun convertir(monto: Double, divisaActual: String, divisaCambio: String): Double {
        var resultado: Double = monto
        when (divisaActual) {
            "USD" -> if (divisaCambio == "CLP") {
                resultado = monto * 817

            } else if (divisaCambio == "USD") {
                resultado = monto * 1
            } else if (divisaCambio == "EUR") {
                resultado = monto * 0.89
            }

            "CLP" -> if (divisaCambio == "CLP") {
                resultado = monto * 1
            } else if (divisaCambio == "USD") {
                resultado = monto * 0.001
            } else if (divisaCambio == "EUR") {
                resultado = monto * 0.001
            }

            "EUR" -> if (divisaCambio == "CLP") {
                resultado = monto * 910
            } else if (divisaCambio == "USD") {
                resultado = monto * 1.11
            } else if (divisaCambio == "EUR") {
                resultado = monto * 1
            }

        }
        return resultado
    }
}