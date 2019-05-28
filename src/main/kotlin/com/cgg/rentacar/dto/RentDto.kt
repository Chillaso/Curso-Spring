package com.cgg.rentacar.dto

data class RentDto(val idRent: Int,
                   val price: Double,
                   val startDateRent: String,
                   val endDateRent: String,
                   val carRented: CarDto,
                   val clientRented: ClientDto)