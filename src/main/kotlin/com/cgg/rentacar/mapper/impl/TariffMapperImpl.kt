package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.dto.TariffDto
import com.cgg.rentacar.mapper.TariffMapper
import com.cgg.rentacar.model.Tariff
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class TariffMapperImpl : TariffMapper
{

    override fun mapToEntity(dto: TariffDto): Tariff = Tariff(dto.idTariff, LocalDate.parse(dto.startDate), LocalDate.parse(dto.endDate), dto.price)
    override fun mapToDto(entity: Tariff): TariffDto = TariffDto(entity.idTariff, entity.startDate.toString(), entity.endDate.toString(), entity.price)
}