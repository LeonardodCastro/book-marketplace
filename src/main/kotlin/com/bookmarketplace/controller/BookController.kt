package com.bookmarketplace.controller

import com.bookmarketplace.model.BookModel
import com.bookmarketplace.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookController(
    val bookService: BookService
) {

    @GetMapping("/all")
    fun getAllBooks(): MutableList<BookModel> {
        return bookService.getAll()
    }
}