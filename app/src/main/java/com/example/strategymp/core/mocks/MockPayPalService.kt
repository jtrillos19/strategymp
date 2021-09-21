package com.example.strategymp.core.mocks

import com.example.strategymp.models.UserData

class MockPayPalService {

    companion object {

        val userData = UserData("jesus@gmai", "12345", true)

        fun getUserDatas(): UserData {
            return userData
        }

        fun validateUser(user: String, userData: UserData): Boolean {
            return userData.email == user
        }

        fun payWithPayPal(amount: Int): Boolean {
            return amount <= 100
        }
    }

}