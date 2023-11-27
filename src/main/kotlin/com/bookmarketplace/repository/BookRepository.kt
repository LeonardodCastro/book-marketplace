package com.bookmarketplace.repository

import com.bookmarketplace.model.BookModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<BookModel,Long>{
}
