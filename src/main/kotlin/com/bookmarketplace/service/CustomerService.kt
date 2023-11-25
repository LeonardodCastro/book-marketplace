package com.bookmarketplace.service

import com.bookmarketplace.model.CustomerModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.bookmarketplace.repository.CustomerRepository
import java.util.*

@Service
class CustomerService(
    @Autowired
    val customerRepository: CustomerRepository
) {
    fun getAll(): List<CustomerModel> {
        return customerRepository.findAll();
    }

    fun getCustomerById(id: Int): Optional<CustomerModel> {
        return customerRepository.findById(id)
    }

    fun save(customerModel: CustomerModel): CustomerModel {
        return customerRepository.save(customerModel)
    }

}