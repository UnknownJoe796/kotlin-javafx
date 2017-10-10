package com.ivieleague.kotlin.javafx

import com.lightningkite.kotlin.async.Async
import com.lightningkite.kotlin.async.AsyncInterface
import javafx.application.Platform

fun javaFxAsyncSetup() {
    Async.uiThreadInterface = object : AsyncInterface {
        override fun sendToThread(action: () -> Unit) {
            Platform.runLater(action)
        }
    }
}