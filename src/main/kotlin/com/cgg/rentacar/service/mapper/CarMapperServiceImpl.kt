package com.cgg.rentacar.service.mapper

import com.cgg.rentacar.model.dto.CarDto
import com.cgg.rentacar.model.entity.CarEntity
import com.cgg.rentacar.service.MapperService

class CarMapperServiceImpl : MapperService<CarDto, CarEntity>{

    override fun map(carDto: CarDto): CarEntity = CarEntity()
}