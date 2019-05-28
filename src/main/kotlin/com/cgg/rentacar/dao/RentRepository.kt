package com.cgg.rentacar.dao

import com.cgg.rentacar.model.Rent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RentRepository : JpaRepository<Rent, String>