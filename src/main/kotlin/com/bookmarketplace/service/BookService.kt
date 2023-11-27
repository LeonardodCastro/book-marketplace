package com.bookmarketplace.service

import com.bookmarketplace.enums.BookStatus
import com.bookmarketplace.model.BookModel
import com.bookmarketplace.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun getAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun addBook(bookModel: BookModel): BookModel {
        return bookRepository.save(bookModel)
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

}
