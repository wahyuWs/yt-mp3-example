package com.wahyus.ytmp3example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.wahyus.ytmp3example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding
    private var qualityMusic = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

        mainActivityBinding.btnSearch.setOnClickListener {
            //call api on viewmodel
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
}