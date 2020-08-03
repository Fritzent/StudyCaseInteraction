package com.example.studycaseinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.studycaseinteraction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //here to embed the fragment into the MainActivity
        fragmentEmbed(AnyFragment())

        binding.btnUseFragmentFunction.setOnClickListener {
            //here the code to call the method from fragment

            val anyFragment = supportFragmentManager.findFragmentById(binding.fragmentEmbeded.id) as? AnyFragment
            anyFragment?.fragmentFunction()
//            AnyFragment().fragmentFunction()
        }
    }

    //here the public function that can using by fragment
    fun summonFunctionMainActivity (){
        Toast.makeText(this,"This is the Function From MainActivity", Toast.LENGTH_SHORT).show()
    }

    private fun fragmentEmbed(anyFragment: AnyFragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentEmbeded.id, anyFragment)
            .commit()
    }
}