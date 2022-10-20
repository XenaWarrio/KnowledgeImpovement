package com.example.patterns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.patterns.adapter.FamilyAdapter
import com.example.patterns.adapter.Partner1
import com.example.patterns.adapter.Partner2
import com.example.patterns.builder.Marriage
import com.example.patterns.decorator.GrandpaDecorator
import com.example.patterns.facade.MotherLife
import com.example.patterns.factory.PresentsFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runFactory()
        runMarriage()
        runFacade()
        runAdapter()
        runDecorator()
    }

    private fun runFactory() {
        PresentsFactory.createPresent("dog")
    }

    private fun runMarriage() {
        Marriage.Builder()
            .fianceObligatory(false)
            .flowersObligatory(false)
            .whiteDressAcceptable(true)
            .setMarriageVow("I will love you forever")
            .closestFriendsObligatory(true)
            .setSpendMoneyAmount(0)
            .build()
    }

    private fun runFacade() {
        MotherLife.raiseAChild()
    }

    private fun runAdapter() {
        FamilyAdapter().talk(Partner1(), Partner2())
    }

    private fun runDecorator() {
        GrandpaDecorator().sum(200, 20, 15)
    }
}