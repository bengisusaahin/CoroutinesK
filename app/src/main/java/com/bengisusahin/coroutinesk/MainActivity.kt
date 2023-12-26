package com.bengisusahin.coroutinesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        //Light Weightness

        GlobalScope.launch {
            repeat(100000){
                launch {
                    println("android")
                }
            }
        }
         */

        //Scope
        //Global Scope, runBlocking, CoroutineScope
/*
        //runBlocking
        println("run blocking start")
        runBlocking {
            //launch coroutine başlatma
            launch {
                delay(5000)
                println("run blocking")
            }
        }
        println("run blocking end")
*/

        /*
        //Global Scope
        println("Global Scope start")
        GlobalScope.launch {
            delay(5000)
            println("Global Scope")

        }
        println("Global Scope end")
        */

        //CoroutineScope
        //Context hangi verilerle çalışcağını söylüyor
        println("coroutine scope start")
        CoroutineScope(Dispatchers.Default ).launch {
            delay(5000)
            println("coroutine scope")
        }
        println("coroutine scope end")


    }
}