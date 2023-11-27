package com.bookmarketplace.model

import com.bookmarketplace.enums.CustomerStatus
import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    var name: String = "",
    @Column
    var email: String = "",
    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus
)