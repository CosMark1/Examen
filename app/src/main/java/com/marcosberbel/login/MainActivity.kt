package com.marcosberbel.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.google.gson.Gson
import com.marcosberbel.login.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = binding.Usuario.text
        val clave = binding.Password.text

        login(usuario,clave)
    }

    fun login(usuario: Editable, clave: Editable){

        val client = OkHttpClient()
        val request = Request.Builder()
        request.url("http://10.0.2.2:8083/anadirDb/$usuario/$clave")


        val call = client.newCall(request.build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.toString())
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainActivity, "Algo ha ido mal", Toast.LENGTH_SHORT)
                        .show()
                }
            }


            override fun onResponse(call: Call, response: Response) {
                println(response.toString())
                response.body?.let { responseBody ->
                    val body = responseBody.string()
                    println(body)




                }

            }


        })

}}


