package com.example.tugasretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasretrofit.databinding.ActivityMainBinding
import com.example.tugasretrofit.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "The Rick and Morty"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character = binding.rvCharacter

        ApiClient.getInstance().getCharacters().enqueue(object : Callback<ResponseCharacter>{
            override fun onResponse(call: Call<ResponseCharacter>, response: retrofit2.Response<ResponseCharacter>) {
                if (response.isSuccessful){
                    // Mendapatkan respons karakter dari server
                    val responseCharacter = response.body()
                    // Mendapatkan daftar karakter dari respons
                    val dataCharacter = responseCharacter?.results
                    // adapter untuk RecyclerView dengan menggunakan data karakter
                    val characterAdapter = CharacterAdapter(dataCharacter)
                    character.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = characterAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseCharacter>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}