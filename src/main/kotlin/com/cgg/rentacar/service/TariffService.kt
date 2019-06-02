package com.cgg.rentacar.service

import com.cgg.rentacar.model.Tariff
import java.util.*

interface TariffService
{
    fun create(dto: Tariff): Optional<Tariff>
}