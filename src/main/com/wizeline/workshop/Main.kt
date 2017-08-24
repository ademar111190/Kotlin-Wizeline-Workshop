package com.wizeline.workshop

fun main(args: Array<String>) {
    println("How much dollars do you want to convert?")

    val input = readLine()

    DollarBitcoinConverter().execute(input)
            .doOnSubscribe {
                println("Please wait meanwhile I convert it")
            }
            .subscribe({
                println("${it.dollar} dollars is equal to ${it.bitcoin} bitcoins")
            }, {
                println("Error ${it.message}")
            })
}
