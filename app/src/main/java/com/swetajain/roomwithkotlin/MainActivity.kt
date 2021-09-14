package com.swetajain.roomwithkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.swetajain.roomwithkotlin.databinding.ActivityMainBinding
import java.sql.Timestamp
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val stamp = Timestamp(System.currentTimeMillis())
        val date = Date(stamp.time)
//        val curTime = DateTime()
//        curTime.dayOfWeek().getAsText(Locale.ENGLISH)
    }
}