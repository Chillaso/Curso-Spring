package com.cgg.rentacar.mapper

import org.springframework.data.domain.Page

/**
 * Interfaz que mapea entidades a DTOs y DTOs a entidades
 * @param T - Tipo de entrada
 * @param S - Tipo de salida
 */
interface Mapper<T, S> {

    fun mapToEntity(t: T): S
    fun mapToDto(s: S): T
    //fun mapDtoPageToEntityPage(t: Page<T>): Page<S>
    fun mapEntityPageToDtoPage(s: Page<S>): Page<T>
}