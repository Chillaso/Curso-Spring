package com.cgg.rentacar.dao

import com.cgg.rentacar.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface CarRepository : JpaRepository<Car, Int>
