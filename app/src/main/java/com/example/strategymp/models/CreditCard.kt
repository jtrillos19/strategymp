package com.example.strategymp.models

class CreditCard(numberCard: String, date: String, cvv: String) {

    private var amount: Int = 0
    var number: String? = null
    var date: String? = null
    var cvv: String? = null

    fun setAmount(amount: Int) {
        this.amount = amount
    }

}