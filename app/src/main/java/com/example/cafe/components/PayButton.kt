package com.example.cafe.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafe.R
import com.example.cafe.viewmodels.OrderViewModel
import com.paypal.checkout.PayPalCheckout
import com.paypal.checkout.approve.OnApprove
import com.paypal.checkout.cancel.OnCancel
import com.paypal.checkout.createorder.CreateOrder
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.OrderIntent
import com.paypal.checkout.createorder.UserAction
import com.paypal.checkout.error.OnError
import com.paypal.checkout.order.Amount
import com.paypal.checkout.order.AppContext
import com.paypal.checkout.order.OrderRequest
import com.paypal.checkout.order.PurchaseUnit

@Composable
fun PayButton(
    orderViewModel: OrderViewModel,
    total: String,
    id: String,
    cantidad: String,
    id_iest: String,
    name: String
) {

    val context = LocalContext.current

    Button(
        colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
        onClick = {
            orderViewModel.isSetting_order = true
            PayPalCheckout.registerCallbacks(
                onApprove = OnApprove { approval ->
                    approval.orderActions.capture { captureOrderResult ->
                        orderViewModel.setUserOrder(id, cantidad, id_iest, name)
                    }
                },
                onCancel = OnCancel {
                    orderViewModel.isSetting_order = false
                    Toast.makeText(context, context.getString(R.string.order_cancel), Toast.LENGTH_SHORT).show()
                },
                onError = OnError {
                    orderViewModel.isSetting_order = false
                    Toast.makeText(context, context.getString(R.string.order_error), Toast.LENGTH_SHORT).show()
                }
            )
            PayPalCheckout.startCheckout(CreateOrder { createOrderActions ->
                val order =
                    OrderRequest(
                        intent = OrderIntent.CAPTURE,
                        appContext = AppContext(userAction = UserAction.PAY_NOW),
                        purchaseUnitList =
                        listOf(
                            PurchaseUnit(
                                amount = Amount(currencyCode = CurrencyCode.MXN, value = total)
                            )
                        )
                    )
                createOrderActions.create(order)
            })
    }) {
        Text(
            text = stringResource(R.string.pay),
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF),
            fontSize = 20.sp
        )
    }
}