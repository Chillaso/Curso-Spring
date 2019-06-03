package com.cgg.rentacar.controller

import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Car
import com.cgg.rentacar.service.BasicCrudService
import com.cgg.rentacar.service.RentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping("/car")
class CarController: BasicCrudController<CarDto, Int>
{
    @Autowired
    lateinit var service: BasicCrudService<Car, Int>
    @Autowired
    lateinit var mapper: Mapper<CarDto, Car>

    @GetMapping
   override fun findAll(@RequestParam("page") page: Int?,
                @RequestParam("size") size: Int?): Page<CarDto> =
            service.findAll(PageRequest.of(page ?: 0, size ?: 20)).let { mapper.mapEntityPageToDtoPage(it) }

    @GetMapping("/{id}")
   override fun findById(@PathVariable("id", required = true) id: Int): CarDto = service.findById(id).let { mapper.mapToDto(it.get()) }

    @PostMapping
    override fun create(@RequestBody dto: CarDto): CarDto
    {
        val result: Optional<Car> = mapper.mapToEntity(dto).let { service.create(it) }
        if(result.isPresent)
            return mapper.mapToDto(result.get())
        else
            throw IllegalArgumentException("Can't create car if idCar has been sended")
    }

    @PutMapping("/{id}")
    override fun update(@RequestBody dto: CarDto, @PathVariable("id", required = true) id: Int)
    {
        if (!service.update(id, mapper.mapToEntity(dto)).isPresent) throw IllegalArgumentException("Can't update car if doesn't exists")
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable("id") id: Int) = service.deleteById(id)

}