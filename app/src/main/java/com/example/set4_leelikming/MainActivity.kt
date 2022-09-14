package com.example.set4_leelikming

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.set4_leelikming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check
        binding.buttonCheck.setOnClickListener() {

            if (binding.editTextCarRegNum.text.toString().isEmpty()) {
                binding.editTextCarRegNum.setError(getString(R.string.error1))
                return@setOnClickListener
            }

            val engineCCInput = binding.editTextEngineCC.text.toString().toIntOrNull()
            var state = binding.spinnerState.selectedItem.toString()

            var roadTax: String? = ""

            if (engineCCInput == null) {
                Toast.makeText(getBaseContext(), "Engine CC Required", Toast.LENGTH_LONG).show();
            }

            if (engineCCInput != null) {
                //if (state == )
                if (engineCCInput.toInt() in 0..1000) {
                    roadTax = "RM 20.00"
                } else if (engineCCInput.toInt() in 1001..1200) {
                    roadTax = "RM 55.00"
                } else if (engineCCInput.toInt() in 1201..1400) {
                    roadTax = "RM 70.00"
                } else if (engineCCInput.toInt() in 1401..1600) {
                    roadTax = "RM 90.00"
                } else if (engineCCInput.toInt() in 1601..3000) {
                    roadTax = "RM 90.00"
                } else {
                    Toast.makeText(getBaseContext(), "Invalid CC. Please input again", Toast.LENGTH_LONG).show();
                }
            }


            //Output
            val regNum = binding.editTextCarRegNum.text.toString()
            val stateShow = binding.spinnerState.selectedItem.toString()

           binding.outputResult.text = String.format(
            "Your Car Registration Number: %s\nYour Engine Capacity: %s\n Your State: %s\n Road Tax is %s",
            regNum,
            engineCCInput,
               stateShow,
            roadTax.toString()

            )

        }

        // Contact Us
        binding.buttonContact.setOnClickListener() {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("tel:03-2225576")
                startActivity(intent)
            }


    }
}