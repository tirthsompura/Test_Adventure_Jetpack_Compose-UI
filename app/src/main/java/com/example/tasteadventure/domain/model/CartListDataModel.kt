package com.example.tasteadventure.domain.model

data class CartListDataModel(
    var icon: Int = 0,
    var name: String = "",
    var weight: String = "",
    var price: Double = 0.00,
    var updatedPrice: Double = 0.00,
    var quantity: Int = 1,
)

data class PriceCartListDataModel(
    var title: String = "",
    var price: Double = 0.00,
)