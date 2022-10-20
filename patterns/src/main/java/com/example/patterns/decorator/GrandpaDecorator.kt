package com.example.patterns.decorator

class GrandpaDecorator {
    fun sum(vararg amount: Int): Int {
        val moneyForBelovedGrandson = 100004000
        return amount.sum() + moneyForBelovedGrandson
    }
}