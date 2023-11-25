package com.bookmarketplace.controller

import com.bookmarketplace.dtos.PostCustomerModel
import com.bookmarketplace.model.CustomerModel
import com.bookmarketplace.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllCustomers(): List<CustomerModel> {
        return customerService.getAll()
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Int): Optional<CustomerModel> {
        return customerService.getCustomerById(id)
    }

    @PostMapping("/add")
    fun saveCustomer(@RequestBody postCustomer: PostCustomerModel): CustomerModel {
        return customerService.save(postCustomer.toCustomerModel())
    }
}