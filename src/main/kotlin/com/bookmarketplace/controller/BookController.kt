package com.bookmarketplace.controller

import com.bookmarketplace.controller.request.PostBookModelRequest
import com.bookmarketplace.controller.request.PutBookModelRequest
import com.bookmarketplace.extensions.toModel
import com.bookmarketplace.model.BookModel
import com.bookmarketplace.service.BookService
import com.bookmarketplace.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @GetMapping("/all")
    fun getAllBooks(): List<BookModel> {
        return bookService.getAll()
    }
    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int): Optional<BookModel> {
        return bookService.getBookById(id)
    }
    @GetMapping("/all/active")
    fun getAllBooksActive(): List<BookModel> {
        return bookService.findActives()
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody postBookModelRequest: PostBookModelRequest): BookModel{
        val customer = customerService.getCustomerById(postBookModelRequest.customerId)
        return bookService.addBook(postBookModelRequest.toModel(customer.get()))
    }
    @DeleteMapping("/remove/{id}")
    fun delete(@PathVariable id: Int){
        return bookService.deleteById(id)
    }
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Int, @RequestBody putBookModelRequest: PutBookModelRequest): BookModel{
        return bookService.updateBook(putBookModelRequest, id)
    }
}