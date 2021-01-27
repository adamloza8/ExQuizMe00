package com.example.exquizme00

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    var listOfQ: ArrayList<Modelclass>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfQ = ArrayList()
        listOfQ!!.add(Modelclass("pytanie", "a", "b", "c", "d", "odpowiedz"))


        @Suppress("DEPRECATION")
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}