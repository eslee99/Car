package com.example.car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculateLoan()
        }

        buttonReset.setOnClickListener(){
            resetInput(buttonReset)
        }
    }
    private fun calculateLoan(){
        val car_price=editTextCarPrice.text.toString().toInt()
        val down_payment=editTextDownPayment.text.toString().toInt()
        val loan_period=editTextLoanPeriod.text.toString().toInt()
        val interest_rate=editTextInterestRate.text.toString().toFloat()

        val loan=car_price-down_payment
        val interest=loan*interest_rate*loan_period
        val monthlyRepayment=(loan+interest)/loan_period/12

        Math.round(interest)
        Math.round(monthlyRepayment)
        textViewCarLoan.text=getString(R.string.loan)+ ": ${loan}"
        textViewInterest.text=getString(R.string.interest)+ ": ${interest}"
        textViewMonthlyRepayment.text=getString(R.string.montly_repayment)+ ": ${monthlyRepayment}"//getString(R.string.montly_repayment,monthlyRepayment.toFloat())
    }
    private fun resetInput(view: View){
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
        textViewCarLoan.text=getString(R.string.loan)
        textViewInterest.text=getString(R.string.interest)
        textViewMonthlyRepayment.text=getString(R.string.montly_repayment)
    }
}
