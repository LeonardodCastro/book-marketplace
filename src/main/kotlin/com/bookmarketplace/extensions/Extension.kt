package com.bookmarketplace.extensions

import com.bookmarketplace.controller.request.PostBookModelRequest
import com.bookmarketplace.controller.request.PostCustomerModelRequest
import com.bookmarketplace.controller.request.PutCustomerModelRequest
import com.bookmarketplace.enums.BookStatus
import com.bookmarketplace.model.BookModel
import com.bookmarketplace.model.CustomerModel

fun PostCustomerModelRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerModelRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}
fun PostBookModelRequest.toModel(customerModel: CustomerModel): BookModel{
    return BookModel(name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customerModel)
}