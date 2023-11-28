package com.bookmarketplace.controller

import com.bookmarketplace.controller.request.PostCustomerModelRequest
import com.bookmarketplace.controller.request.PutCustomerModelRequest
import com.bookmarketplace.controller.response.CustomerModelResponse
import com.bookmarketplace.extensions.toCustomerModel
import com.bookmarketplace.extensions.toResponse
import com.bookmarketplace.model.CustomerModel
import com.bookmarketplace.service.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAllCustomers(name: String?): List<CustomerModelResponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Int): Optional<CustomerModelResponse> {
        return customerService.getCustomerById(id).map { it.toResponse() }
    }

    @PostMapping("/add")
    fun saveCustomer(@RequestBody postCustomer: PostCustomerModelRequest): CustomerModelResponse {
        return customerService.save(postCustomer.toCustomerModel()).toResponse()
    }

    @PutMapping("/update/{id}")
    fun updateCustomer(
        @PathVariable id: Int,
        @RequestBody putCustomer: PutCustomerModelRequest
    ): CustomerModelResponse {
        return customerService.update(id, putCustomer).toResponse()
    }

    @DeleteMapping("/delete-permanently/{id}")
    fun deleteCustomerPermanently(@PathVariable id: Int) {
        return customerService.deleteById(id)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteCustomer(@PathVariable id: Int) : CustomerModelResponse{
        return customerService.toInactive(id)
    }
}