package com.cgg.rentacar.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class CarDto(
        val idCar: Int,
        @NotNull val carPlate: String,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")val registrationYear: String,
        @NotNull val model: String)