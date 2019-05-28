package com.cgg.rentacar.dto

data class TariffDto(val idTariff: Int,
                     val startDate: String,
                     val endDate: String,
                     val price: Double)