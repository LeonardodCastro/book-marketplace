package com.bookmarketplace.controller.response

import com.bookmarketplace.enums.BookStatus
import com.bookmarketplace.model.CustomerModel
import java.math.BigDecimal

data class BookModelResponse (
    var id: Long? = null,
    var name: String = "",
    var price: BigDecimal,
    var status: BookStatus? = null,
    var customer: CustomerModel? = null
)
