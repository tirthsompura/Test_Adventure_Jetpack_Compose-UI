package com.example.tasteadventure.presentation.cart

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.CartListDataModel
import com.example.tasteadventure.domain.model.PriceCartListDataModel
import com.example.tasteadventure.util.SessionManagerClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    val sessionManagerClass: SessionManagerClass,
) : ViewModel() {

    private val _cartListState = mutableStateListOf<CartListDataModel>()
    val cartListState = _cartListState

    private val _priceCartListState = mutableStateListOf<PriceCartListDataModel>()
    val priceCartListState = _priceCartListState

    init {
        _cartListState.add(
            CartListDataModel(
                icon = R.drawable.ic_intro_img2,
                name = "Tamales",
                weight = "240",
                price = 34.90,
                updatedPrice = 34.90,
                quantity = 1,
            )
        )

        _cartListState.add(
            CartListDataModel(
                icon = R.drawable.ic_intro_img,
                name = "Carnitas",
                weight = "280",
                price = 48.90,
                updatedPrice = 48.90,
                quantity = 1,
            )
        )


        _priceCartListState.add(
            PriceCartListDataModel(
                title = "Subtotal",
                price = 118.70,
            )
        )

        _priceCartListState.add(
            PriceCartListDataModel(
                title = "Delivery Fee",
                price = 12.50,
            )
        )

        _priceCartListState.add(
            PriceCartListDataModel(
                title = "Discount",
                price = 6.50,
            )
        )
    }

    fun updateQuantity(index: Int, value: Int) {
        if (value == -1) {
            if (_cartListState[index].quantity > 1) {
                val qty = cartListState[index].quantity - 1
                Log.d("#QTY", _cartListState[index].quantity.toString())
                _cartListState[index] = cartListState[index].copy(
                    quantity = qty,
                    updatedPrice = cartListState[index].price * qty
                )
            } else {
                _cartListState.removeAt(index)
            }
        } else {
            val qty = cartListState[index].quantity + 1
            Log.d("#QTY", _cartListState[index].quantity.toString())
            _cartListState[index] = cartListState[index].copy(
                quantity = qty,
                updatedPrice = cartListState[index].price * qty
            )
        }
    }
}