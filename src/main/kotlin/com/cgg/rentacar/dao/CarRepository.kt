package com.cgg.rentacar.dao

import com.cgg.rentacar.model.entity.CarEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<CarEntity, String>