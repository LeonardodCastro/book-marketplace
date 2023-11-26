package com.bookmarketplace.extensions

import com.bookmarketplace.dtos.PostCustomerModelRequest
import com.bookmarketplace.dtos.PutCustomerModelRequest
import com.bookmarketplace.model.CustomerModel

fun PostCustomerModelRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerModelRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}