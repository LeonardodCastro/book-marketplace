package com.bookmarketplace.service

import com.bookmarketplace.controller.request.PutBookModelRequest
import com.bookmarketplace.enums.BookStatus
import com.bookmarketplace.model.BookModel
import com.bookmarketplace.repository.BookRepository
import org.springframework.stereotype.Service
import java.util.*

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

    fun getBookById(id: Int): Optional<BookModel> {
        return bookRepository.findById(id.toLong())
    }

    fun deleteById(id: Int) {
        return bookRepository.deleteById(id.toLong())
    }

    fun updateBook(putBookModelRequest: PutBookModelRequest, id: Int): BookModel {
        val book = bookRepository.findById(id.toLong())
        if (book.isPresent){
            book.filter { it.id == id.toLong() }.let {
                it.get().name = putBookModelRequest.name
                it.get().price = putBookModelRequest.price;
                return bookRepository.save(book.get())
            }
        }else{
            throw Exception()
        }
    }

}
