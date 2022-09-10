package com.kanneki.textinputedittext

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.kanneki.textinputedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customInputLayout.setEndIconOnClickListener {
            Toast.makeText(
                this,
                "input text: ${binding.customInputText.text}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.errorInputText.doOnTextChanged { text, start, before, count ->
            if((text?.length ?: 0) > 10) {
                binding.errorInputLayout.error = "No More!"
            } else {
                binding.errorInputLayout.error = null
            }
        }

    }

}