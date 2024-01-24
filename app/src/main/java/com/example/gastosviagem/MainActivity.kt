package com.example.gastosviagem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastosviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        if ((binding.editDistance.text.isNotEmpty() && binding.editPrice.text.isNotEmpty() && binding.editAutonomy.text.isNotEmpty()) &&
            (binding.editDistance.text.toString() != "0" && binding.editPrice.text.toString() != "0" && binding.editAutonomy.text.toString() != "0"))
            {
            return true
        }
        return false
    }


    private fun calculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (price * distance) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this, "Preencha todos os valores corretamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }


}