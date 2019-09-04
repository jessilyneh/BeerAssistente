package com.BeerAssistente.Beer.Assistente.Gerenciador.repositories;

import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CervejaRepository extends CrudRepository<Cerveja,Long> {

    boolean existsByTipo (String tipo);

    static Cerveja findOne(Long id) {
        return null;
    }
    @Override
    List<Cerveja> findAll();


    Cerveja findByTipoCerveja (String tipoCerveja);

    List<Cerveja> findAllByTipoCerveja( String tipoCerveja);

}
