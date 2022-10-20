package com.example.patterns.adapter

class FamilyAdapter {
    fun talk(partner1: Partner1I, partner2: Partner2I) {
        partner2.listen("I love u so m${partner1.scream()}ch")
        partner1.listen("Sometimes I say ${partner2.swear()} because I'm afraid of losing you")
    }
}

interface Partner2I {
    fun swear(): String
    fun listen(text: String)
}

class Partner2 : Partner2I {
    override fun swear() = "You are nothing without me"
    override fun listen(text: String) {}
}

interface Partner1I {
    fun scream(): String
    fun listen(text: String)
}

class Partner1 : Partner1I {
    override fun scream() = "AAAAAAAA"
    override fun listen(text: String) {}
}