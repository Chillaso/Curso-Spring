package com.cgg.rentacar.model

import javax.persistence.*

@Entity
data class Tariff(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val idTariff: Int,
        val startDate: String,
        val endDate: String,
        val price: Double,
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tariff") val cars: List<Car> = ArrayList()
)