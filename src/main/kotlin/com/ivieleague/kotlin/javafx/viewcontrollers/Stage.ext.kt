package com.ivieleague.kotlin.javafx.viewcontrollers

import javafx.stage.Stage

fun Stage.bindStack(stack: VCStack) {
    title = stack.current.title
    scene.root = stack.current.makeView(this)
    stack.onChange += {
        println("On change to $it")
        title = it.title
        scene.root = stack.current.makeView(this)
    }
}