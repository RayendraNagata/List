package com.example.list

import Disaster
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val AdapterDisaster = DisasterAdapter(generatedataDummy()) {
                disaster ->
            Toast.makeText(this@MainActivity , "You clicked on ${disaster.nameDisaster}",
                Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvDisaster.apply {
                adapter = AdapterDisaster
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun generatedataDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural", imageResId = R.drawable.tsunami),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "Natural", imageResId = R.drawable.volcano),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural", imageResId = R.drawable.earthquake),
            Disaster(nameDisaster = "Flood", disasterType = "Natural", imageResId = R.drawable.flood),
            Disaster(nameDisaster = "Fire", disasterType = "Accidental", imageResId = R.drawable.fire)
        )
    }


}


