package com.cgg.rentacar.service

import java.util.*

/**
 * Interface basica para un CRUD sencillo.
 * @param S - Tipo de objeto sobre el que estamos operando.
 * @param ID - Tipo del identificador de S
 */
interface BasicCrudService<S,ID> {

    fun findAll(): Collection<S>
    fun findById(id: ID): S
    fun create(s: S): S
    fun update(s: S): S
    fun deleteById(id: ID)
}