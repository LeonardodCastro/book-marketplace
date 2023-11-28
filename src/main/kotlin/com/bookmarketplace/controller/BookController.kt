package com.bookmarketplace.controller

import com.bookmarketplace.controller.request.PostBookModelRequest
import com.bookmarketplace.controller.request.PutBookModelRequest
import com.bookmarketplace.controller.response.BookModelResponse
import com.bookmarketplace.extensions.toModel
import com.bookmarketplace.extensions.toResponse
import com.bookmarketplace.service.BookService
import com.bookmarketplace.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
    fun getAllBooks(@PageableDefault(page = 0, size = 10)pageable: Pageable): Page<BookModelResponse> {
        return bookService.getAll(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int): Optional<BookModelResponse> {
        return bookService.getBookById(id).map { it.toResponse() }
    }

    @GetMapping("/all/active")
    fun getAllBooksActive(@PageableDefault(page = 0, size = 10)pageable: Pageable): Page<BookModelResponse> {
        return bookService.findActives(pageable).map { it.toResponse() }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody postBookModelRequest: PostBookModelRequest): BookModelResponse {
        val customer = customerService.getCustomerById(postBookModelRequest.customerId)
        return bookService.addBook(postBookModelRequest.toModel(customer.get())).toResponse()
    }

    @DeleteMapping("/remove/{id}")
    fun delete(@PathVariable id: Int) {
        return bookService.deleteById(id)
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Int, @RequestBody putBookModelRequest: PutBookModelRequest): BookModelResponse {
        return bookService.updateBook(putBookModelRequest, id).toResponse()
    }

    @GetMapping("/cancel/{id}")
    fun cancelBook(@PathVariable id: Int): BookModelResponse {
        return bookService.cancelBook(id).toResponse()
    }

}