package com.ivieleague.kotlin.javafx.viewcontrollers

import com.lightningkite.kotlin.invokeAll
import java.util.*

class VCStack {
    private val stack = ArrayList<ViewController>()
    val current: ViewController get() = stack.last()
    val onChange = ArrayList<(ViewController) -> Unit>()

    fun push(vc: ViewController) {
        stack.add(vc)
        onChange.invokeAll(vc)
    }

    fun pop() {
        assert(stack.size >= 2)
        stack.removeAt(stack.lastIndex)
        onChange.invokeAll(current)
    }

    fun reset(vc: ViewController) {
        stack.clear()
        stack.add(vc)
        onChange.invokeAll(vc)
    }

    fun swap(vc: ViewController) {
        stack.set(stack.lastIndex, vc)
        onChange.invokeAll(vc)
    }

    fun refresh() {
        onChange.invokeAll(current)
    }

    fun root() {
        val first = stack.first()
        stack.clear()
        stack.add(first)
        onChange.invokeAll(current)
    }
}