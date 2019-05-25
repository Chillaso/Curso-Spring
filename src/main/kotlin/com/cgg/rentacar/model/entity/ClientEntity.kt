package com.cgg.rentacar.model.entity

import java.util.*
import javax.persistence.*

@Entity
data class ClientEntity(
        @Id @GeneratedValue val idClient: Int,
        val name: String,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientRented") var rents: Set<RentEntity> = TreeSet()
)