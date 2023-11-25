package com.bookmarketplace.dtos

import com.bookmarketplace.model.CustomerModel

data class PostCustomerModel(var name: String, var email: String) {
    fun toCustomerModel(): CustomerModel {
        return CustomerModel(name = this.name, email = this.email)
    }
}