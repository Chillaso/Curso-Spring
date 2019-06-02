package com.cgg.rentacar.mapper

import com.cgg.rentacar.dto.TariffDto
import com.cgg.rentacar.model.Tariff

interface TariffMapper
{
    fun mapToEntity(dto: TariffDto): Tariff
    fun mapToDto(entity: Tariff): TariffDto
}