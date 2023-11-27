package com.bookmarketplace.controller.request

import java.math.BigDecimal

data class PutBookModelRequest(
    var name: String,
    var price: BigDecimal,
)
