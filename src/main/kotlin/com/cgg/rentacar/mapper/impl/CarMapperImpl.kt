package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Car
import javassist.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CarMapperImpl : Mapper<CarDto, Car>
{
    override fun mapToEntity(t: CarDto): Car = Car(t.idCar, t.carPlate, LocalDate.parse(t.registrationYear), t.model)

    override fun mapToDto(s: Car): CarDto = CarDto(s.idCar, s.carPlate, s.registrationYear.toString(), s.model)

    override fun mapEntityPageToDtoPage(s: Page<Car>): Page<CarDto>
    {
        if(s.isEmpty) throw NotFoundException("Not found")

        //TODO: Encontrar una manera mas sencilla y rapida de hacer esto
        val dtoBuffer = mutableListOf<CarDto>()
        s.forEach { dtoBuffer.add(mapToDto(it)) }
        return PageImpl(dtoBuffer, s.pageable, s.totalElements)
    }
}

