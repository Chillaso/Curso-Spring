package com.cgg.rentacar.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class ClientDto(
        val idClient: Int,
        //FIXME: No funciona bien al expresion regular
        @NotNull @Size(min = 9, max = 10) @Pattern(regexp = "\\d{8}-?[a-zA-Z]") val dni: String,
        @NotNull val name: String)