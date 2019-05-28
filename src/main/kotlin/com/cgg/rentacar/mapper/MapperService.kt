package com.cgg.rentacar.mapper

import java.util.*

/**
 * Interfaz que mapea entidades a DTOs y DTOs a entidades
 * @param T - Tipo de entrada
 * @param S - Tipo de salida
 */
interface MapperService<T, S> {

    fun mapToEntity(t: T): S
    fun mapToDto(s: S): T
    fun mapDtoCollectionToEntityCollection(t: Collection<T>): Collection<S>
    fun mapEntityCollectionToDtoCollection(s: Collection<S>): Collection<T>
}