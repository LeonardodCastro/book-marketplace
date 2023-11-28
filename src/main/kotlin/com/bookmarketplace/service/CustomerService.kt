package com.bookmarketplace.service

import com.bookmarketplace.controller.request.PutCustomerModelRequest
import com.bookmarketplace.controller.response.CustomerModelResponse
import com.bookmarketplace.enums.CustomerStatus
import com.bookmarketplace.extensions.toResponse
import com.bookmarketplace.model.CustomerModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.bookmarketplace.repository.CustomerRepository
import java.util.*
import kotlin.Exception

@Service
class CustomerService(
    @Autowired
    val customerRepository: CustomerRepository
) {
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll();
    }

    fun getCustomerById(id: Int): Optional<CustomerModel> {
        return customerRepository.findById(id)
    }

    fun save(customerModel: CustomerModel): CustomerModel {
        return customerRepository.save(customerModel)
    }

    fun update(id: Int, putCustomer: PutCustomerModelRequest): CustomerModel {
        val customer = customerRepository.findById(id)
            if (customer.isPresent) {
                customer.filter { it.id == id.toLong() }.let {
                    it.get().name = putCustomer.name
                    it.get().email = putCustomer.email
                    return customerRepository.save(customer.get())
                }
            } else {
                throw Exception()
            }
        }

    fun deleteById(id: Int) {
        return customerRepository.deleteById(id)
    }

    fun toInactive(id: Int) : CustomerModelResponse {
        val customer = customerRepository.findById(id)
        if (customer.isPresent){
            customer.filter {
                it.id == id.toLong() }.let {
                it.get().status = CustomerStatus.INACTIVE }
            return  customerRepository.save(customer.get()).toResponse()
        } else{
            throw Exception()
        }
    }
}
