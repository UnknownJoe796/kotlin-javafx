package com.ivieleague.kotlin.javafx.viewcontrollers

import javafx.scene.Parent
import javafx.stage.Stage

interface ViewController {
    val title: String
    fun makeView(stage: Stage): Parent
}