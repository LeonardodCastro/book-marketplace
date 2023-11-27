package com.bookmarketplace.model

import com.bookmarketplace.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    var name: String = "",
    @Column
    var prince: BigDecimal,
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
)