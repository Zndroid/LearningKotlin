package com.hakz.learningkotlin.domain.commands

interface Command<out T> {
    fun execute(): T
}