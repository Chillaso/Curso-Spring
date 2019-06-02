package com.cgg.rentacar.controller

import com.cgg.rentacar.dto.TariffDto
import com.cgg.rentacar.mapper.TariffMapper
import com.cgg.rentacar.model.Tariff
import com.cgg.rentacar.service.TariffService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/tariff")
class TariffController {

    @Autowired lateinit var service: TariffService
    @Autowired lateinit var mapper: TariffMapper

    @PostMapping
    fun create(@RequestBody dto: TariffDto): TariffDto
    {
        /*
            Validacion gitana porque en el dto no se puede hacer el @Min
         */
        if(dto.price < 0) throw IllegalArgumentException("Price must be higher than 0")

        val result: Optional<Tariff> = mapper.mapToEntity(dto).let { service.create(it) }
        if(result.isPresent)
            return mapper.mapToDto(result.get())
        else
            throw IllegalArgumentException("Can't create Tariff if idTariff has been sended")
    }
}