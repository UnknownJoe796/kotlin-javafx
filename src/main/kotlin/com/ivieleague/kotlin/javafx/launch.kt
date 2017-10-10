package com.ivieleague.kotlin.javafx

import com.ivieleague.kotlin.javafx.viewcontrollers.VCStack
import com.ivieleague.kotlin.javafx.viewcontrollers.bindStack
import javafx.stage.Stage

fun VCStack.popup(): Stage {
    return Stage().apply {
        bindStack(this@popup)
        show()
    }
}