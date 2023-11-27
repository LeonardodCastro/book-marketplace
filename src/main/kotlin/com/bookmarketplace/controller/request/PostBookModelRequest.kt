package com.bookmarketplace.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookModelRequest (
    var name: String,
    var price: BigDecimal,
    @JsonAlias("customer_id")
    var customerId: Int
)