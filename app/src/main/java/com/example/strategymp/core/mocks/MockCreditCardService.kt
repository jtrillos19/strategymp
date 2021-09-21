package com.example.strategymp.core.mocks

import com.example.strategymp.models.CreditCard

class MockCreditCardService {

    companion object {

        val creditCardData = CreditCard("58464648767", "06/05", "666")

        fun getCreditCardDatas(): CreditCard {
            return creditCardData
        }

        fun payWithCard(amount: Int): Boolean {
            return amount <= 100000
        }

        fun validateCVV(cvv: String, creditCard: CreditCard): Boolean {
            return creditCard.cvv == cvv
        }
    }


}