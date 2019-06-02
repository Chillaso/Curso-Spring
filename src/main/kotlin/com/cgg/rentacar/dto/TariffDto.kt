package com.cgg.rentacar.dto

import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern


data class TariffDto(
        val idTariff: Int,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") val startDate: String,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") val endDate: String,
        @NotNull @DecimalMin(value = "0") val price: Double)