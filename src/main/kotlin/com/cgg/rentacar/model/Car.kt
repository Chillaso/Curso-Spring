package com.cgg.rentacar.model

import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
data class Car(
        /**El idCar es la matricula del coche, entendiendo que no se puede repetir nunca*/
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var idCar: Int = 0,
        var carPlate: String = "",
        var registrationYear: String = "01/01/1970",
        var model: String = "",
        /**
            Entendemos que es "val" porque podemos annadir nuevas tarifas, pero
            no podemos borrar las demas

            Tambien sera un TreeSet porque entendemos que no habra tarifas repetidas
            porque una tarifa pertenece a una sola fecha. Ademas queremos tener los valores
            ordenados por fecha. Podria haber dos tarifas que tengan el mismo dia, por ejemplo
            que se hayan equivocado al meter la tarifa, pero entonces su precio seria diferente
         */
        @ManyToMany(fetch = FetchType.LAZY) val tariff: Set<Tariff> = TreeSet(),
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "carRented") val rent: Set<Rent> = HashSet())
