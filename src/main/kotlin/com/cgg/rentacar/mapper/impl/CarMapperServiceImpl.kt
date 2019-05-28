package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.mapper.MapperService
import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.model.Car
import org.springframework.stereotype.Component
import java.util.*

@Component
class CarMapperServiceImpl : MapperService<CarDto, Car>
{

    override fun mapToEntity(t: CarDto): Car = Car(t.idCar, t.carPlate, t.registrationYear, t.model)

    override fun mapToDto(s: Car): CarDto = CarDto(s.idCar, s.carPlate, s.registrationYear, s.model)

    override fun mapDtoCollectionToEntityCollection(t: Collection<CarDto>): Collection<Car>
    {
        val set = mutableSetOf<Car>()
        t.forEach { set.add(Car(idCar = it.idCar, carPlate = it.carPlate, registrationYear = it.registrationYear, model = it.model)) }
        return set
    }

    override fun mapEntityCollectionToDtoCollection(s: Collection<Car>): Collection<CarDto>
    {
        val set = mutableSetOf<CarDto>()
        s.forEach { set.add(CarDto(idCar = it.idCar, carPlate = it.carPlate, registrationYear = it.registrationYear, model = it.model)) }
        return set
    }
}

