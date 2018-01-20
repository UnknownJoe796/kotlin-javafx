package com.ivieleague.kotlin.javafx

import com.lightningkite.kotlin.lifecycle.LifecycleConnectable
import com.lightningkite.kotlin.lifecycle.LifecycleListener
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.Node
import javafx.scene.Scene
import javafx.stage.Window
import java.util.*

class NodeLifecycleConnectable(val node: Node) : LifecycleConnectable {

    val listeners = ArrayList<LifecycleListener>()
    var started = false

    fun refresh() {
        if (node.scene?.window?.isShowing == true)
            start()
        else
            stop()
    }

    var currentWindow: Window? = null
    val showingListener = object : ChangeListener<Boolean> {
        override fun changed(observable: ObservableValue<out Boolean>, oldValue: Boolean, newValue: Boolean) {
            if (newValue) {
                start()
            } else {
                stop()
            }
        }
    }

    var currentScene: Scene? = null
    val windowListener = object : ChangeListener<Window> {
        override fun changed(observable: ObservableValue<out Window>?, oldValue: Window?, newValue: Window?) {
            moveShowingListener(newValue)
        }
    }

    fun moveShowingListener(window: Window?) {
        currentWindow?.showingProperty()?.removeListener(showingListener)
        currentWindow = window
        window?.showingProperty()?.addListener(showingListener)
        refresh()
    }

    fun moveSceneListener(scene: Scene?) {
        currentScene?.windowProperty()?.removeListener(windowListener)
        currentScene = scene
        scene?.windowProperty()?.addListener(windowListener)
        moveShowingListener(scene?.window)
    }

    init {
        node.sceneProperty().addListener { observable, oldValue, newValue ->
            moveSceneListener(newValue)
        }
        moveSceneListener(node.scene)
        refresh()
    }

    override fun connect(listener: LifecycleListener) {
        if (started) {
            listener.onStart()
        }
        listeners += listener
    }

    fun start() {
        if (started) return
        started = true
        listeners.forEach { it.onStart() }
    }

    fun stop() {
        if (!started) return
        started = false
        listeners.forEach { it.onStop() }
    }
}

val Node_lifecycle = WeakHashMap<Node, LifecycleConnectable>()
val Node.lifecycle: LifecycleConnectable get() = Node_lifecycle.getOrPut(this) { NodeLifecycleConnectable(this) }