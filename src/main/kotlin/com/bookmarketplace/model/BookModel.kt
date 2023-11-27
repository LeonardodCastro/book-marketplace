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
    var price: BigDecimal,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.CANCELED || field == BookStatus.DELETED)
                throw Exception("Can't change book status when with $status status")
            field = value
        }

    constructor(
        id: Long? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?
    ) : this(id, name, price, customer) {
        this.status = status
    }
}