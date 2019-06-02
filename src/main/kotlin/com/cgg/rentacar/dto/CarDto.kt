package com.cgg.rentacar.dto

import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class CarDto(
        val idCar: Int = -1,
        @NotNull val carPlate: String,
        @NotNull /*@Pattern(regexp = "dd/MM/yyyy", message = "Incorrect patter, insert: dd/MM/yyyy date")*/ val registrationYear: String,
        @NotNull val model: String)