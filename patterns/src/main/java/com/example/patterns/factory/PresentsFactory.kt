package com.example.patterns.factory

object PresentsFactory {
    fun createPresent(present: String): PresentsI {
        return when (present) {
            "car" -> Car()
            "dog" -> Dog()
            "house" -> House()
            else -> Flowers()
        }
    }
}

class Car : PresentsI
class Dog : PresentsI
class House : PresentsI
class Flowers : PresentsI

interface PresentsI