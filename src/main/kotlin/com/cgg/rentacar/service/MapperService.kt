package com.cgg.rentacar.service

interface MapperService<T,S> {
    fun map(t: T) : S
    /*
        Seria correcto tener en el mapper service las dos funciones? la de ida y la de vuelta?
        Yo creo que si porque cumple SRP, al final es una interfaz que tiene que mapear y eso no viola
        el SRP, pero si puede llegar a incumplir la ISP
        fun mapToDto(s: S) : T
     */
}