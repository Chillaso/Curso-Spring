package com.cgg.rentacar.controller

import com.cgg.rentacar.dto.ClientDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Client
import com.cgg.rentacar.service.BasicCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/client")
class ClientController: BasicCrudController<ClientDto, Int>
{
    @Autowired
    lateinit var service: BasicCrudService<Client, Int>
    @Autowired
    lateinit var mapper: Mapper<ClientDto, Client>

    @GetMapping
    override fun findAll(@RequestParam("page") page: Int?,
                @RequestParam("size") size: Int?): Page<ClientDto> =
            service.findAll(PageRequest.of(page ?: 0, size ?: 20)).let { mapper.mapEntityPageToDtoPage(it) }

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id", required = true) id: Int): ClientDto = service.findById(id).let { mapper.mapToDto(it.get()) }

    @PostMapping
    override fun create(@RequestBody dto: ClientDto): ClientDto
    {
        //TODO: Refactorizar para mejorar la legibilidad
        val result: Optional<Client> = mapper.mapToEntity(dto).let { service.create(it) }
        if(result.isPresent)
            return mapper.mapToDto(result.get())
        else
            throw IllegalArgumentException("Can't create Client if idClient has been sended")
    }

    @PutMapping("/{id}")
    override fun update(@RequestBody dto: ClientDto, @PathVariable("id", required = true) id: Int)
    {
        if (!service.update(id, mapper.mapToEntity(dto)).isPresent) throw IllegalArgumentException("Can't update Client if doesn't exists")
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable("id") id: Int) = service.deleteById(id)
}