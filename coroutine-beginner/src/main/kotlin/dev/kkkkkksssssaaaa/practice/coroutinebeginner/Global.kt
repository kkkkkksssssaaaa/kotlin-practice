package dev.kkkkkksssssaaaa.practice.coroutinebeginner

fun printWithThread(str: Any) {
    println("[${Thread.currentThread().name} $str]")
}