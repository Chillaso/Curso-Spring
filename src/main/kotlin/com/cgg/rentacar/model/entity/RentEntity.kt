package com.cgg.rentacar.model.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class RentEntity(
        /**
         * La id en este caso debe de ser compuesta, con el id del usuario del coche, el id del cliente
         * y la fecha de inicio y fin
         */
        @Id val idRent: String,
        val startDateRent: LocalDate,
        val endDateRent: LocalDate,
        val price: Double,
        @ManyToOne(fetch = FetchType.LAZY) val carRented: CarEntity,
        @ManyToOne(fetch = FetchType.LAZY) val clientRented: ClientEntity
)