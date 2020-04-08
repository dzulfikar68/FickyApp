package com.hijrahdulu.fickyapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set spinner religion
        ArrayAdapter.createFromResource(
            this,
            R.array.religion,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            religionSpinner?.adapter = adapter
        }

        //set button ok
        okButton?.setOnClickListener {
            //get radio button gender
            val radioGroup: RadioGroup? = genderRadioGroup
            val radioButton: RadioButton? =
                radioGroup?.findViewById(genderRadioGroup?.checkedRadioButtonId ?: 0)

            //show toast
            Toast.makeText(
                this,
                "Hi, nama saya ${nameEditText?.text?.trim() ?: "John Doe"},\n" +
                        "saya seorang ${radioButton?.text?.trim() ?: "Laki-laki"},\n" +
                        "agama saya ${religionSpinner?.selectedItem ?: "Islam"}.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
