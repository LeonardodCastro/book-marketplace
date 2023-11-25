package com.bookmarketplace.dtos

import com.bookmarketplace.model.CustomerModel

data class PostCustomerModelRequest(var name: String, var email: String) {
    fun toCustomerModel(): CustomerModel {
        return CustomerModel(name = this.name, email = this.email)
    }
}