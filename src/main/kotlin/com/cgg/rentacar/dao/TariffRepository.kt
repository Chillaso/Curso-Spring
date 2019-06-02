package com.cgg.rentacar.dao

import com.cgg.rentacar.model.Tariff
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TariffRepository : JpaRepository<Tariff, Int>