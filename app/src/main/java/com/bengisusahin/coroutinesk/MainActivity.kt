package com.bengisusahin.coroutinesk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import java.lang.Exception

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
//        println("coroutine scope start")
//        CoroutineScope(Dispatchers.Default ).launch {
//            delay(5000)
//            println("coroutine scope")
//        }
//        println("coroutine scope end")


        //Exception Handling
//        lifecycleScope.launch {
//            try {
//                throw Exception("error")
//            }catch (e: Exception){
//                e.printStackTrace()
//            }
//        }

        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("exception: " + throwable.localizedMessage)
        }

//        lifecycleScope.launch(handler) {
//            throw Exception("error")
//        }
//
//        lifecycleScope.launch(handler) {
//            launch {
//                throw Exception("error2") //bir launch ın hata vermesi yeterli
//            }
//            launch {
//                delay(500L)
//                println("executed")
//            }
//        }


        lifecycleScope.launch(handler) {
            supervisorScope {
                launch {
                    throw Exception("error2") //supervisorle etkilemiyo dierlerini
                }
                launch {
                    delay(500L)
                    println("executed")
                }

            }
        }

        CoroutineScope(Dispatchers.Main + handler).launch {
            launch {
                throw Exception("error in a coroutineScope")
            }
        }

    }
}