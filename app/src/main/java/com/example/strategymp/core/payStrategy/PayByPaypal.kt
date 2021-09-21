package com.example.strategymp.core.payStrategy

import com.example.strategymp.core.mocks.MockPayPalService
import com.example.strategymp.models.excepcion.UserDataFailure


class PayByPaypal : PayStrategy {

    lateinit var userEmail: String

    override fun collectPaymentDetails() {

        val user = userEmail
        if (user!=String()){
            UserDataFailure("Invalid User Email")
        }
        val userData = MockPayPalService.getUserDatas()
        if (!MockPayPalService.validateUser(user, userData)){
            UserDataFailure("User email does not match")
        }
    }

    override fun pay(paymentAmount: Int): Boolean {
        return MockPayPalService.payWithPayPal(paymentAmount)
    }
}