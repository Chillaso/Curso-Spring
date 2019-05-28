package com.cgg.rentacar.controller

import com.cgg.rentacar.dto.CarDto
import com.cgg.rentacar.service.BasicCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/car")
class CarController
{

    @Autowired
    lateinit var service: BasicCrudService<CarDto, Int>

    @GetMapping
    fun getAllCars(): Collection<CarDto>
    {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun getCarById(@PathVariable("id") id: Int): CarDto
    {
        try
        {
            return service.findById(id)
        }
        catch (e: NullPointerException)
        {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        }
    }

    @PostMapping
    fun createCar(@RequestBody dto: CarDto): CarDto = service.create(dto)

}