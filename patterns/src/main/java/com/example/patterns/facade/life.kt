package com.example.patterns.facade

object MotherLife {
    fun raiseAChild() {
        Home().apply {
            cry()
            askMumForHelp()
            cry()
            askFriendsForHelp()
        }
        Kindergarten().apply {
            buyCleanCloses()
            sendToKindergarten()
            payForKindergarten()
            takeFromKindergarten()
        }
        School().apply {
            buyCleanCloses()
            takeToSchool()
            pay()
            takeFromSchool()
        }
        University().apply {
            payForUniversity()
            sendChildToAnotherCity()
            relax()
        }
    }
}

class Home {
    fun askMumForHelp() {}
    fun cry() {}
    fun askFriendsForHelp() {}
}

class Kindergarten {
    fun buyCleanCloses() {}
    fun sendToKindergarten() {}
    fun payForKindergarten() {}
    fun takeFromKindergarten() {}
}

class School {
    fun buyCleanCloses() {}
    fun takeToSchool() {}
    fun pay() {}
    fun takeFromSchool() {}
}

class University {
    fun payForUniversity() {}
    fun sendChildToAnotherCity() {}
    fun relax() {
        stillBeNervous()
    }
    private fun stillBeNervous() {}
}
