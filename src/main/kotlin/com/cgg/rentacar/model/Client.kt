package com.cgg.rentacar.model

import java.util.*
import javax.persistence.*

@Entity
data class Client(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val idClient: Int = 0,
        val dni: String = "",
        val name: String = "",
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientRented") val rents: Set<Rent> = TreeSet()
)