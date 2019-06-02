package com.cgg.rentacar.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Rent(
        /**
         * La id en este caso debe de ser compuesta, con el id del usuario del coche, el id del cliente
         * y la fecha de inicio y fin
         */
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val idRent: Int = 0,
        val startDateRent: LocalDate = LocalDate.now(),
        val endDateRent: LocalDate = LocalDate.now(),
        val price: Double = 0.0,
        @ManyToOne(fetch = FetchType.LAZY) val carRented: Car = Car(),
        @ManyToOne(fetch = FetchType.LAZY) val clientRented: Client = Client()
)