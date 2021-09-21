package com.example.strategymp.core.payStrategy

import com.example.strategymp.core.mocks.MockCreditCardService
import com.example.strategymp.models.excepcion.InvalidoCVV
import com.example.strategymp.models.excepcion.UserDataFailure

class PayByCreditCard : PayStrategy {

    lateinit var cardCVV: String

    override fun collectPaymentDetails() {
        val cvv = cardCVV
        if (cvv != String()) {
            InvalidoCVV("Invalid CVV")
        }
        val card = MockCreditCardService.getCreditCardDatas()
        if (!MockCreditCardService.validateCVV(cvv, card)) {
            UserDataFailure("CVV does not match")
        }

    }

    override fun pay(paymentAmount: Int): Boolean {
        return MockCreditCardService.payWithCard(paymentAmount)
    }

}