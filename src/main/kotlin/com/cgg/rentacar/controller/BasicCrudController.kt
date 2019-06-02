package com.cgg.rentacar.controller

import org.springframework.data.domain.Page

interface BasicCrudController<T, ID>
{
    fun findAll(page: Int?, size: Int?): Page<T>
    fun findById(id: ID): T
    fun create(t: T): T
    fun update(t: T, id: ID)
    fun deleteById(id: ID)
}