package com.example.strategymp.views.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.strategymp.R
import com.example.strategymp.core.context.OrderContext
import com.example.strategymp.core.payStrategy.PayByCreditCard
import com.example.strategymp.core.payStrategy.PayByPaypal
import com.example.strategymp.core.payStrategy.PayStrategy
import com.example.strategymp.models.excepcion.UserDataFailure

class DemoActivity : AppCompatActivity() {

    private lateinit var order: OrderContext
    private var payPalStrategy = PayByPaypal()
    private var creditCardStrategy = PayByCreditCard()
    private lateinit var strategy: PayStrategy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPaypal: RadioButton = findViewById(R.id.btnPaypal)
        order = OrderContext(payPalStrategy)
        btnPaypal.isChecked = true
    }

    private fun collectViewData() {
        val edTotalCost: EditText = findViewById(R.id.edTotalCost)
        val edCVV: EditText = findViewById(R.id.edCVV)
        val edPaypal: EditText = findViewById(R.id.edPaypal)
        val cost = edTotalCost.text.toString()
        order.setTotalCost(cost.toInt())
        val payPalData = edPaypal.text.toString()
        payPalStrategy.userEmail = payPalData
        val cvv = edCVV.text.toString()
        creditCardStrategy.cardCVV = cvv
    }

    private fun choseStrategy(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.btnPayOrder ->
                    if (checked) {
                        strategy = payPalStrategy
                    }
                R.id.btnCreditCard ->
                    if (checked) {
                        strategy = creditCardStrategy
                    }
            }
        }
    }

    fun payOrder(view: View) {
        collectViewData()
        order.setClosed()
        choseStrategy(view)
        try {
            order.processOrder()
        } catch (message: Exception) {
            Toast.makeText(this, "Payment Failure $message", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this, "Sucesss", Toast.LENGTH_SHORT).show()

    }
}