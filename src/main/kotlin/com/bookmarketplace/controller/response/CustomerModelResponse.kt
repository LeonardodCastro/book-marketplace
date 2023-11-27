package com.bookmarketplace.controller.response

import com.bookmarketplace.enums.CustomerStatus

data class CustomerModelResponse(
    var id: Long? = null,
    var name: String = "",
    var email: String = "",
    var status: CustomerStatus
)