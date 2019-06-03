package com.cgg.rentacar.dto

import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent
import javax.validation.constraints.Pattern

data class RentDto(
        val idRent: Int,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") @PastOrPresent val startDate: String,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") @FutureOrPresent val endDate: String,
        @NotNull val price: Double,
        @NotNull val car: CarDto,
        @NotNull val client: ClientDto)