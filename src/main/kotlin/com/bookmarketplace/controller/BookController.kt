package com.bookmarketplace.controller

import com.bookmarketplace.controller.request.PostBookModelRequest
import com.bookmarketplace.extensions.toModel
import com.bookmarketplace.model.BookModel
import com.bookmarketplace.service.BookService
import com.bookmarketplace.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @GetMapping("/all")
    fun getAllBooks(): MutableList<BookModel> {
        return bookService.getAll()
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody postBookModelRequest: PostBookModelRequest): BookModel{
        val customer = customerService.getCustomerById(postBookModelRequest.customerId)
        return bookService.addBook(postBookModelRequest.toModel(customer.get()))
    }

}