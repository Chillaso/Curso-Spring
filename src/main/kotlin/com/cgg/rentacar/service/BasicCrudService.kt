package com.cgg.rentacar.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*


/**
 * Interface basica para un CRUD sencillo.
 * @param S - Tipo de objeto sobre el que estamos operando.
 * @param ID - Tipo del identificador de S
 */
interface BasicCrudService<S,ID> {

    fun findAll(pageable: Pageable): Page<S>
    fun findById(id: ID): Optional<S>
    fun create(s: S): S
    /**
     * Metodo de update de una entidad, que valida si se esta insertando o no mediante este metodo
     * @param S s - Tipo del objeto sobre el que operamos
     * @return Optional.empty en caso de que se este intentando insertar un objeto mediante
     * este metodo de entrada. Optional<S> si se ha realizado correctamente el merge.
     */
    fun update(id: ID, s: S): Optional<S>
    fun deleteById(id: ID)
}