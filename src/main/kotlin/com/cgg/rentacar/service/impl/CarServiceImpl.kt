package com.cgg.rentacar.service.impl

import com.cgg.rentacar.dao.CarRepository
import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.mapper.MapperService
import com.cgg.rentacar.model.Car
import com.cgg.rentacar.service.BasicCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarServiceImpl : BasicCrudService<CarDto, Int>
{
    @Autowired
    lateinit var repository: CarRepository
    @Autowired
    lateinit var mapper: MapperService<CarDto, Car>

    override fun findAll(): Collection<CarDto> = mapper.mapEntityCollectionToDtoCollection(repository.findAll())

    /**
     * Busca un coche por ID y mapea el resultado a un DTO
     * @param Int id - Id por el que buscar, no nulo.
     * @return CarDto car - Entidad coche mapeado a DTO.
     * @throws NullPointerException si no fue encontrado nada.
     */
    override fun findById(id: Int): CarDto = mapper.mapToDto(repository.findById(id).orElseThrow { NullPointerException("Car not found") })

    override fun create(s: CarDto): CarDto = mapper.mapToEntity(s).let { repository.save(it) }.let { mapper.mapToDto(it) }

    override fun update(s: CarDto): CarDto = mapper.mapToEntity(s).let { mapper.mapToDto(repository.save(it)) }

    override fun deleteById(id: Int) = repository.deleteById(id)

}