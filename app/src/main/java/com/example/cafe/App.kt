package com.example.cafe

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.paypal.checkout.PayPalCheckout
import com.paypal.checkout.config.CheckoutConfig
import com.paypal.checkout.config.Environment
import com.paypal.checkout.config.SettingsConfig
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.UserAction

class App : Application() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate() {
        super.onCreate()

        PayPalCheckout.setConfig(
            checkoutConfig = CheckoutConfig(
                application = this,
                clientId = PAYPAL_CLIENT_ID_SANDBOX,
                environment = Environment.SANDBOX,
                currencyCode = CurrencyCode.MXN,
                userAction = UserAction.PAY_NOW,
                settingsConfig = SettingsConfig(
                    loggingEnabled = true,
                    showWebCheckout = false
                ),
                returnUrl = "com.example.cafe://paypalpay"
            )
        )
    }

    companion object {
        const val PAYPAL_CLIENT_ID_SANDBOX = "AZcDa4UNI086TfJnj4LA_10KsZBFMcWBnzJ1qAagc_m2OLZ6828gzCG4lhDZQNFf6Q4l2so4fVHsjXOS"
    }
}