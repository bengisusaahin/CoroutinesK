package com.bengisusahin.coroutinesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Light Weightness

        GlobalScope.launch {
            repeat(100000){
                launch {
                    println("android")
                }
            }
        }
    }
}