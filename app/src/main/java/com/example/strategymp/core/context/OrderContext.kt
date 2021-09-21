package com.example.strategymp.core.context

import com.example.strategymp.core.payStrategy.PayStrategy


class OrderContext(payStrategy: PayStrategy) {

    private var totalCost = 0
    private var isClosed = false
    private var strategy: PayStrategy = payStrategy

    fun processOrder(): Boolean {
        strategy.collectPaymentDetails()
        return strategy.pay(totalCost)
    }

    fun setTotalCost(cost: Int) {
        totalCost += cost
    }

    fun setClosed() {
        isClosed = true
    }

}
