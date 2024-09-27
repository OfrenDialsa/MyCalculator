package com.example.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var input1 = findViewById<EditText>(R.id.input1)
        var input2 = findViewById<EditText>(R.id.input2)
        var btnTmb = findViewById<Button>(R.id.tambah)
        var btnKrg = findViewById<Button>(R.id.kurang)
        var btnKli = findViewById<Button>(R.id.kali)
        var btnBgi = findViewById<Button>(R.id.bagi)
        var hasil = findViewById<TextView>(R.id.hasil)
        var stts = findViewById<TextView>(R.id.status)

        try {



            btnTmb.setOnClickListener{
                if (input1.text.toString().isNotEmpty() && input2.text.toString().isNotEmpty()) {
                    val Int1 = input1.text.toString().toInt()
                    val Int2 = input2.text.toString().toInt()

                    val tmbh = Int1 + Int2

                    stts.text = "Ditambah"
                    hasil.text = "$tmbh"

                } else {
                    // Handle the case where the input is empty
                    Toast.makeText(this, "Masukkin angka dulu :(", Toast.LENGTH_SHORT).show()
                }
            }

            btnKrg.setOnClickListener{

                if (input1.text.toString().isNotEmpty() && input2.text.toString().isNotEmpty()) {
                    val Int1 = input1.text.toString().toInt()
                    val Int2 = input2.text.toString().toInt()

                    val krg = Int1 - Int2
                    stts.text = "Dikurang"

                    hasil.text = "$krg"

                } else {
                    // Handle the case where the input is empty
                    Toast.makeText(this, "Masukkin angka dulu :(", Toast.LENGTH_SHORT).show()
                }

            }

            btnKli.setOnClickListener{

                if (input1.text.toString().isNotEmpty() && input2.text.toString().isNotEmpty()) {
                    val Int1 = input1.text.toString().toInt()
                    val Int2 = input2.text.toString().toInt()

                    val kli = Int1 * Int2
                    stts.text = "Dikali"

                    hasil.text = "$kli"

                } else {
                    // Handle the case where the input is empty
                    Toast.makeText(this, "Masukkin angka dulu :(", Toast.LENGTH_SHORT).show()
                }
            }
            btnBgi.setOnClickListener{

                if (input1.text.toString().isNotEmpty() && input2.text.toString().isNotEmpty()) {
                    val Int1 = input1.text.toString().toInt()
                    val Int2 = input2.text.toString().toInt()

                    if (Int2 != 0) {
                        val bgi = Int1 / Int2
                        stts.text = "Dibagi"
                        hasil.text = "$bgi"
                    } else {
                        hasil.text = "Angka tidak bisa dibagi 0"
                    }

                } else {
                    // Handle the case where the input is empty
                    Toast.makeText(this, "Masukkin angka dulu :(", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: NumberFormatException) {
            // Handle the exception
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
        }



    }
}
