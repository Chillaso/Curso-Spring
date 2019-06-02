package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.dto.TariffDto
import com.cgg.rentacar.model.Tariff

interface TariffMapper
{
    fun mapToEntity(dto: TariffDto): Tariff
    fun mapToDto(entity: Tariff): TariffDto
}