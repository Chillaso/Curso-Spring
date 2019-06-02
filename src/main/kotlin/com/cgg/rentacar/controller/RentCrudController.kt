package com.cgg.rentacar.controller

import com.cgg.rentacar.dto.RentDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Rent
import com.cgg.rentacar.service.BasicCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/client/car")
class RentCrudController: BasicCrudController<RentDto, Int>
{
    @Autowired lateinit var service: BasicCrudService<Rent, Int>
    @Autowired lateinit var mapper: Mapper<RentDto, Rent>

    @GetMapping
    override fun findAll(@RequestParam("page") page: Int?,
                @RequestParam("size") size: Int?): Page<RentDto> =
            service.findAll(PageRequest.of(page ?: 0, size ?: 20)).let { mapper.mapEntityPageToDtoPage(it) }

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id", required = true) id: Int): RentDto = service.findById(id).let { mapper.mapToDto(it.get()) }

    @PostMapping
    override fun create(@RequestBody dto: RentDto): RentDto
    {
        val result: Optional<Rent> = mapper.mapToEntity(dto).let { service.create(it) }
        if (result.isPresent)
            return mapper.mapToDto(result.get())
        else
            throw IllegalArgumentException("Can't create Rent if idRent has been sended")
    }

    @PutMapping("/{id}")
    override fun update(@RequestBody dto: RentDto, @PathVariable("id", required = true) id: Int)
    {
        if (!service.update(id, mapper.mapToEntity(dto)).isPresent) throw IllegalArgumentException("Can't update Rent if doesn't exists")
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable("id") id: Int) = service.deleteById(id)
}