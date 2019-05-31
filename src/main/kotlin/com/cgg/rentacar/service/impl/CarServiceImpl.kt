package com.cgg.rentacar.service.impl

import com.cgg.rentacar.dao.CarRepository
import com.cgg.rentacar.model.Car
import com.cgg.rentacar.service.BasicCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarServiceImpl : BasicCrudService<Car, Int>
{
    @Autowired
    lateinit var repository: CarRepository

    override fun findAll(pageable: Pageable): Page<Car> = repository.findAll(pageable)

    /**
     * Busca un coche por ID y mapea el resultado a un DTO
     * @param Int id - Id por el que buscar, no nulo.
     * @return CarDto car - Entidad coche mapeado a DTO.
     * @throws NullPointerException si no fue encontrado nada.
     */
    override fun findById(id: Int): Optional<Car> = repository.findById(id)

    override fun create(s: Car): Car = repository.save(s)

    /**
     * Metodo de update de una entidad, que valida si se esta insertado o no mediante
     * una comprobacion interna que comprueba si el objeto es nuevo o no,
     * si el objeto no existe, lanzamos un optional vacio.
     * @param S s - Tipo del objeto sobre el que operamos
     * @return Optional.empty en caso de que se este intentando insertar un objeto mediante
     * este metodo de entrada. Optional<S> si se ha realizado correctamente el merge.
     */
    override fun update(id: Int, s: Car): Optional<Car> = repository.findById(id).map { repository.save(s) }

    override fun deleteById(id: Int) = repository.deleteById(id)
}