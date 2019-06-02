package com.cgg.rentacar.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class TariffDto(
        val idTariff: Int,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") val startDate: String,
        @NotNull @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") val endDate: String,
        /*
            Este campo no se puede validar con @Min porque no esta soportado. Para ello deberia de
            ser al menos de tipo BigDecimal.
         */
        @NotNull val price: Double)