package com.cgg.rentacar.dao

import com.cgg.rentacar.model.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientEntity, Int>