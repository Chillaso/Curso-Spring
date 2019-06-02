package com.cgg.rentacar.service.impl

import com.cgg.rentacar.dao.TariffRepository
import com.cgg.rentacar.model.Tariff
import com.cgg.rentacar.service.TariffService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TariffServiceImpl: TariffService
{
    @Autowired lateinit var repository: TariffRepository
    /**
     * Metodo que comprueba primeramente si el id de la tarifa existe, en caso de que sea asi
     * retornamos un Optional vacio indicando que esta operacion no se puede realizar, ya que
     * estariamos si no haciendo un update, en vez de un create.
     * En caso contrario procedemos al guardado normal
     * @param Tariff dto - Tarifa, con o sin id previo.
     * @return Optional con el valor de la tarifa, o Optional.empty en caso de exista un tarifa con el id.
     */
    override fun create(dto: Tariff): Optional<Tariff>
    {
        return when (repository.findById(dto.idTariff).isPresent)
        {
            true -> Optional.empty()
            false -> Optional.of(repository.save(dto))
        }
    }
}