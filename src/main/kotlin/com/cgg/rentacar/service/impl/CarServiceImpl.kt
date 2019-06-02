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

    /**
     * Metodo que busca todos los coches disponibles en la base de datos
     * y lo devuelve paginados.
     * @param Pageable pageable - Objeto pageable necesario para la paginacion
     * @return Page<Car> - resultado pageado
     */
    override fun findAll(pageable: Pageable): Page<Car> = repository.findAll(pageable)

    /**
     * Busca un coche por ID y mapea el resultado a un DTO
     * @param Int id - Id por el que buscar, no nulo.
     * @return CarDto car - Entidad coche mapeado a DTO.
     */
    override fun findById(id: Int): Optional<Car> = repository.findById(id)

    /**
     * Metodo que comprueba primeramente si el id del coche existe, en caso de que sea asi
     * retornamos un Optional vacio indicando que esta operacion no se puede realizar, ya que
     * estariamos si no haciendo un update, en vez de un create.
     * En caso contrario procedemos al guardado normal
     * @param Car s - Coche, con o sin id previo.
     * @return Optional con el valor del coche, o Optional.empty en caso de exista un coche con el id.
     */
    override fun create(s: Car): Optional<Car>
    {
        return when (repository.findById(s.idCar).isPresent)
        {
            true -> Optional.empty()
            false -> Optional.of(repository.save(s))
        }
    }

    /**
     * Metodo de update de una entidad, que valida si se esta insertado o no mediante
     * una comprobacion interna que comprueba si el objeto es nuevo o no,
     * si el objeto no existe, lanzamos un optional vacio.
     * @param S s - Tipo del objeto sobre el que operamos
     * @return Optional.empty en caso de que se este intentando insertar un objeto mediante
     * este metodo de entrada. Optional<S> si se ha realizado correctamente el merge.
     */
    override fun update(id: Int, s: Car): Optional<Car> =
            repository.findById(id)
                    .map { repository.save(Car(id, s.carPlate, s.registrationYear, s.model, s.tariff, s.rent)) }

    /**
     * Borra un coche por un id
     * @param Int id
     */
    override fun deleteById(id: Int) = repository.deleteById(id)
}