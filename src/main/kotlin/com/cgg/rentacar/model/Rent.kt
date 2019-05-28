package com.cgg.rentacar.model

import javax.persistence.*

@Entity
data class Rent(
        /**
         * La id en este caso debe de ser compuesta, con el id del usuario del coche, el id del cliente
         * y la fecha de inicio y fin
         */
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val idRent: Int,
        val startDateRent: String,
        val endDateRent: String,
        val price: Double,
        @ManyToOne(fetch = FetchType.LAZY) val carRented: Car,
        @ManyToOne(fetch = FetchType.LAZY) val clientRented: Client
)