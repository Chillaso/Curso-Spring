package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.dto.ClientDto
import com.cgg.rentacar.dto.RentDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Car
import com.cgg.rentacar.model.Client
import com.cgg.rentacar.model.Rent
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class RentMapperImpl : Mapper<RentDto, Rent> 
{
    @Autowired lateinit var carMapper: Mapper<CarDto, Car>
    @Autowired lateinit var clientMapper: Mapper<ClientDto, Client>

    override fun mapToEntity(t: RentDto): Rent = Rent(
            t.idRent,
            LocalDate.parse(t.startDateRent),
            LocalDate.parse(t.endDateRent),
            t.price,
            carMapper.mapToEntity(t.carRented),
            clientMapper.mapToEntity(t.clientRented))

    override fun mapToDto(s: Rent): RentDto = RentDto(
            s.idRent,
            s.startDateRent.toString(),
            s.endDateRent.toString(),
            s.price,
            carMapper.mapToDto(s.carRented),
            clientMapper.mapToDto(s.clientRented))

    override fun mapEntityPageToDtoPage(s: Page<Rent>): Page<RentDto>
    {
        if(s.isEmpty) throw NotFoundException("Not found")

        //TODO: Encontrar una manera mas sencilla y rapida de hacer esto
        val dtoBuffer = mutableListOf<RentDto>()
        s.forEach { dtoBuffer.add(mapToDto(it)) }
        return PageImpl(dtoBuffer, s.pageable, s.totalElements)
    }
}