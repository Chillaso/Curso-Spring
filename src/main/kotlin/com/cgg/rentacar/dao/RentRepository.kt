package com.cgg.rentacar.dao

import com.cgg.rentacar.model.Car
import com.cgg.rentacar.model.Rent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface RentRepository : JpaRepository<Rent, Int>
{
    fun findAllCarRentedByEndDateRentBetweenOrderByPrice(start: LocalDate, end: LocalDate): Collection<Car>
}