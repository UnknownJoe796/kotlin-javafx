package com.ivieleague.kotlin.javafx.viewcontrollers

import javafx.scene.Scene
import javafx.stage.Stage

fun Stage.bindStack(stack: VCStack) {
    title = stack.current.title
    scene = Scene(stack.current.makeView(this))
    stack.onChange += {
        title = it.title
        scene = Scene(it.makeView(this))
    }
}