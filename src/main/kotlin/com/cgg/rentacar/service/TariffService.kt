package com.cgg.rentacar.service

import com.cgg.rentacar.dto.TariffDto

interface TariffService
{
    fun create(dto: TariffDto): TariffDto
}