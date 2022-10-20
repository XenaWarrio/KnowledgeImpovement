package com.example.patterns.builder

class Marriage private constructor(
    val whiteDress: Boolean?,
    val flowers: Boolean?,
    val fiance: Boolean?,
    val closestFriends: Boolean?,
    val marriageVow: String?,
    val moneyAmount: Int?

) {
    class Builder {
        private var whiteDress: Boolean? = null
        private var flowers: Boolean? = null
        private var fiance: Boolean = false
        private var closestFriends: Boolean? = null
        private var marriageVow: String = "I don't like you enough for this"
        private var moneyAmount: Int = 0

        fun whiteDressAcceptable(value: Boolean) = apply { whiteDress = value }

        fun flowersObligatory(value: Boolean) = apply { flowers = value }

        fun fianceObligatory(value: Boolean) = apply { fiance = value }

        fun closestFriendsObligatory(value: Boolean) = apply { closestFriends = value }

        fun setMarriageVow(value: String) = apply { marriageVow = value }

        fun setSpendMoneyAmount(value: Int) = apply { moneyAmount = value }

        fun build() =
            Marriage(whiteDress, flowers, fiance, closestFriends, marriageVow, moneyAmount)
    }
}