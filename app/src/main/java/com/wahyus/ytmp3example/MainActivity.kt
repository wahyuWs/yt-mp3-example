package com.wahyus.ytmp3example

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import com.wahyus.ytmp3example.databinding.ActivityMainBinding
import com.wahyus.ytmp3example.network.response.DataMp3
import com.wahyus.ytmp3example.network.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding
    private var qualityMusic = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

        mainActivityBinding.btnSearch.setOnClickListener {
            //call api
            val url = mainActivityBinding.edtUrl.text.toString().trim()
            if (url.isNotEmpty()) {
                getDownloadFile(this, url, qualityMusic)
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when(view.id) {
                R.id.rb_64 -> if (checked) {
                    qualityMusic = 64
                }
                R.id.rb_128 -> if (checked) {
                    qualityMusic = 128
                }
                R.id.rb_256 -> if (checked) {
                    qualityMusic = 256
                }
                R.id.rb_192 -> if (checked) {
                    qualityMusic = 192
                }
                R.id.rb_320 -> if (checked) {
                    qualityMusic = 320
                }
            }
        }
    }

    private fun getDownloadFile(context: Context, url: String, quality: Int) {
        val client = ApiConfig.getApiService(context).getData(url, quality)
        client.enqueue(object : Callback<DataMp3> {
            override fun onResponse(call: Call<DataMp3>, response: Response<DataMp3>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Log.d("MainActivity", "OnSuccess: ${responseBody}")
                    }
                } else {
                    Log.e("MainActivity", "OnFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DataMp3>, t: Throwable) {
                Log.e("MainActivity", "OnFailure: ${t.message}")
            }
        })
    }
}