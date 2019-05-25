package com.cgg.rentacar.model.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class TariffEntity(
        //Duda, como compongo este idTariff de forma que represente, coche,fecha,precio.
        @Id val idTariff: String,
        val startDate: LocalDate,
        val endDate: LocalDate,
        val price: Double,
        /*
            No tengo claro como reflejar esto, porque podria darse el caso en el que quisieramos
            representar algo asi como

            coche 1 - tarifa 1
            coche 1 - tarifa 2
            coche 2 - tarifa 1

            En el caso de coche 2 si queremos aplicarle la misma tarifa que a coche 1 entonces
            no podriamos tener una Set porque se podrian repetir

            Si queremos que una tarifa pertenezca a un unico coche, entonces debemos de tener un identificador
            compuesto que nos diga a que coche pertenece la tarifa
         */
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tariff") val cars: List<CarEntity> = ArrayList()
)