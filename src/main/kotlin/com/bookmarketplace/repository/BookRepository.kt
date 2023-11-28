package com.bookmarketplace.repository

import com.bookmarketplace.enums.BookStatus
import com.bookmarketplace.model.BookModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<BookModel,Long>{
    fun findByStatus(status: BookStatus, pageable: Pageable, ): Page<BookModel>
}
