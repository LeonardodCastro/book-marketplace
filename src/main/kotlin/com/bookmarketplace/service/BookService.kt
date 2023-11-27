package com.bookmarketplace.service

import com.bookmarketplace.model.BookModel
import com.bookmarketplace.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun getAll(): MutableList<BookModel> {
        return bookRepository.findAll()
    }

}
