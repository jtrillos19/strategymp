package com.example.strategymp.core.payStrategy

interface PayStrategy {

    fun pay(paymentAmount: Int): Boolean
    fun collectPaymentDetails()
}