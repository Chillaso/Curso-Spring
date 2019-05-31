package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Car
import javassist.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class CarMapperImpl : Mapper<CarDto, Car>
{
    override fun mapToEntity(t: CarDto): Car = Car(t.idCar, t.carPlate, t.registrationYear, t.model)

    override fun mapToDto(s: Car): CarDto = CarDto(s.idCar, s.carPlate, s.registrationYear, s.model)

/*    override fun mapDtoPageToEntityPage(t: Page<CarDto>): Page<Car>
    {
        val dtoBuffer = mutableListOf<Car>()
        t.forEach { dtoBuffer.add(mapToEntity(it)) }
        return PageImpl(dtoBuffer, t.pageable, t.totalElements)
    }*/

    override fun mapEntityPageToDtoPage(s: Page<Car>): Page<CarDto>
    {
        if(s.isEmpty) throw NotFoundException("Not found")

        //TODO: Encontrar una manera mas sencilla y rapida de hacer esto
        val dtoBuffer = mutableListOf<CarDto>()
        s.forEach { dtoBuffer.add(mapToDto(it)) }
        return PageImpl(dtoBuffer, s.pageable, s.totalElements)
    }
}

