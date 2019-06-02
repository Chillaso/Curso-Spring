package com.cgg.rentacar.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Tariff(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val idTariff: Int = 0,
        val startDate: LocalDate = LocalDate.now(),
        val endDate: LocalDate = LocalDate.now(),
        val price: Double = 0.0,
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tariff") val cars: List<Car> = ArrayList()
)