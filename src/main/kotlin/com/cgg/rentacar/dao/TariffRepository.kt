package com.cgg.rentacar.dao

import com.cgg.rentacar.model.entity.TariffEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TariffRepository : JpaRepository<TariffEntity, String>