package com.cgg.rentacar.model

import java.time.LocalDate
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
data class Car(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val idCar: Int = 0,
        val carPlate: String = "",
        val registrationYear: LocalDate = LocalDate.now(),
        val model: String = "",
        @ManyToMany(fetch = FetchType.LAZY) val tariff: Set<Tariff> = TreeSet(),
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "carRented") val rent: Set<Rent> = HashSet())
