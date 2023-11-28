package com.bookmarketplace.service

import com.bookmarketplace.controller.request.PutBookModelRequest
import com.bookmarketplace.enums.BookStatus
import com.bookmarketplace.model.BookModel
import com.bookmarketplace.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun getAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun addBook(bookModel: BookModel): BookModel {
        return bookRepository.save(bookModel)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
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

    fun cancelBook(id: Int): BookModel {
        val book = bookRepository.findById(id.toLong())
        if (book.isPresent){
            book.get().status = BookStatus.CANCELED
          return  bookRepository.save(book.get())
        }
        throw Exception()
    }

}
