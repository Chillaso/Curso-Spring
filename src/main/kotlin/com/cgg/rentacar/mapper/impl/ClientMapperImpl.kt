package com.cgg.rentacar.mapper.impl

import com.cgg.rentacar.dto.ClientDto
import com.cgg.rentacar.mapper.Mapper
import com.cgg.rentacar.model.Client
import javassist.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class ClientMapperImpl : Mapper<ClientDto, Client>
{
    override fun mapToEntity(t: ClientDto): Client = Client(t.idClient, t.dni, t.name)

    override fun mapToDto(s: Client): ClientDto = ClientDto(s.idClient, s.dni, s.name)

    override fun mapEntityPageToDtoPage(s: Page<Client>): Page<ClientDto>
    {
        if(s.isEmpty) throw NotFoundException("Not found")

        //TODO: Encontrar una manera mas sencilla y rapida de hacer esto
        val dtoBuffer = mutableListOf<ClientDto>()
        s.forEach { dtoBuffer.add(mapToDto(it)) }
        return PageImpl(dtoBuffer, s.pageable, s.totalElements)
    }
}