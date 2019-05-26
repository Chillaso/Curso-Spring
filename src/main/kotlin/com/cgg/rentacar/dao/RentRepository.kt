package com.cgg.rentacar.dao

import com.cgg.rentacar.model.entity.RentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RentRepository : JpaRepository<RentEntity, String>