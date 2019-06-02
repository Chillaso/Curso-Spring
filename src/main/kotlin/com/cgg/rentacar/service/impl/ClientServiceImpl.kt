package com.cgg.rentacar.service.impl

import com.cgg.rentacar.dao.ClientRepository
import com.cgg.rentacar.model.Client
import com.cgg.rentacar.service.BasicCrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientServiceImpl : BasicCrudService<Client, Int>
{
    @Autowired
    lateinit var repository: ClientRepository

    /**
     * Metodo que busca todos los Clientes disponibles en la base de datos
     * y lo devuelve paginados.
     * @param Pageable pageable - Objeto pageable necesario para la paginacion
     * @return Page<Client> - resultado pageado
     */
    override fun findAll(pageable: Pageable): Page<Client> = repository.findAll(pageable)

    /**
     * Busca un Cliente por ID y mapea el resultado a un DTO
     * @param Int id - Id por el que busClient, no nulo.
     * @return ClientDto Client - Entidad Cliente mapeado a DTO.
     */
    override fun findById(id: Int): Optional<Client> = repository.findById(id)

    /**
     * Metodo que comprueba primeramente si el id del Cliente existe, en caso de que sea asi
     * retornamos un Optional vacio indicando que esta operacion no se puede realizar, ya que
     * estariamos si no haciendo un update, en vez de un create.
     * En caso contrario procedemos al guardado normal
     * @param Client s - Cliente, con o sin id previo.
     * @return Optional con el valor del Cliente, o Optional.empty en caso de exista un Cliente con el id.
     */
    override fun create(s: Client): Optional<Client>
    {
        return when (repository.findById(s.idClient).isPresent)
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
    override fun update(id: Int, s: Client): Optional<Client> =
            repository.findById(id)
                    .map { repository.save(Client(id, s.dni, s.name)) }

    /**
     * Borra un Cliente por un id
     * @param Int id
     */
    override fun deleteById(id: Int) = repository.deleteById(id)
}