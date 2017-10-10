package com.ivieleague.kotlin.javafx

import com.lightningkite.kotlin.lifecycle.LifecycleConnectable
import com.lightningkite.kotlin.lifecycle.LifecycleListener
import javafx.scene.Node
import java.util.*

class NodeLifecycleConnectable(val node: Node) : LifecycleConnectable {

    val listeners = ArrayList<LifecycleListener>()
    var started = false

    init {
        node.sceneProperty().addListener { observable, oldValue, newValue ->
            if (newValue == null) {
                stop()
            } else {
                start()
            }
        }
        if (node.scene != null) {
            start()
        }
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