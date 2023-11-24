package com.bookmarketplace.controller

import com.bookmarketplace.model.CustomerModel
import com.bookmarketplace.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getCustomer(id: Int): Optional<CustomerModel> {
        return customerService.getCustomerById(id)
    }

    @PostMapping
    fun saveCustomer(@RequestBody customerModel: CustomerModel): CustomerModel {
        return customerService.save(customerModel)
    }
}
