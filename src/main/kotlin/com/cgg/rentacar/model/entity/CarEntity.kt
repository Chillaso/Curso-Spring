package com.cgg.rentacar.model.entity

import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
data class CarEntity(
        /**El idCar es la matricula del coche, entendiendo que no se puede repetir nunca*/
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var idCar: String = "",
        var model: String = "",
        var doors: Int = 0,
        /**
            Entendemos que es "val" porque podemos annadir nuevas tarifas, pero
            no podemos borrar las demas

            Tambien sera un TreeSet porque entendemos que no habra tarifas repetidas
            porque una tarifa pertenece a una sola fecha. Ademas queremos tener los valores
            ordenados por fecha. Podria haber dos tarifas que tengan el mismo dia, por ejemplo
            que se hayan equivocado al meter la tarifa, pero entonces su precio seria diferente
         */
        @ManyToMany(fetch = FetchType.LAZY) val tariff: Set<TariffEntity> = TreeSet(),
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "carRented") val rent: Set<RentEntity> = HashSet())
