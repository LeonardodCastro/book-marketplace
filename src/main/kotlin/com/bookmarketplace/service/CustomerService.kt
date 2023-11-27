package com.bookmarketplace.service

import com.bookmarketplace.controller.request.PutCustomerModelRequest
import com.bookmarketplace.model.CustomerModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.bookmarketplace.repository.CustomerRepository
import java.lang.Exception
import java.util.*

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

    fun update(id: Long, putCustomer: PutCustomerModelRequest): CustomerModel {
        customerRepository.findById(id.toInt()).filter { it.id == id }.let {
            if (it.isPresent) {
                val customer = it.get()
                customer.name = putCustomer.name
                customer.email = putCustomer.email
                return customerRepository.save(customer)
            } else {
                throw Exception()
            }
        }
    }

    fun deleteById(id: Int) {
        return customerRepository.deleteById(id)
    }
}
