package com.cgg.rentacar.service

import com.cgg.rentacar.model.Car
import com.cgg.rentacar.model.Rent
import java.time.LocalDate
import java.util.*

interface RentService: BasicCrudService<Rent, Int>
{
    fun findByProfit(startDate: LocalDate, endDate: LocalDate): Optional<Car>
}