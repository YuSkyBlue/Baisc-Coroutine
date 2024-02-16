package org.example.cps

import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread



fun main() {
    continuationNetworkCall {
        println("Network Call Finish")
    }
}

fun continuationNetworkCall(callcc: () -> Unit) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://www.naver.com,")
        .build()
    val response = client.newCall(request).execute()
    println(response.body?.string())
    callcc()
}