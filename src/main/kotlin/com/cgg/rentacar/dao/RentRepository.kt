package com.cgg.rentacar.dao

import com.cgg.rentacar.model.Rent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface RentRepository : JpaRepository<Rent, Int>
{
    /*
        NOTA: ASI ES COMO DEBERIA DE SER, PERO COMO EL DTO NO RECIBE TARIFA, PUES ENTONCES
        NO PODEMOS HACER LA RELACION BIEN
    */
    fun findFirstByEndDateBetweenOrderByCarTariffPriceDesc(start: LocalDate, end: LocalDate): Rent
}