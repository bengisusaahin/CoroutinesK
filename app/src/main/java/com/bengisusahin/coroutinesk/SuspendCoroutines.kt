package com.bengisusahin.coroutinesk

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    //icerisinde coroutine çalıştırılabilen fonksiyonlardır
    runBlocking {
        delay(2000)
        println("run blocking")
        myFunc()
    }
}

suspend fun myFunc(){
    coroutineScope {
        delay(4000)
        println("suspend func")
    }
}