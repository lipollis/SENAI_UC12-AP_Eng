package com.ApEng.Ap_Engenharia.repositories;

import com.ApEng.Ap_Engenharia.models.Parceiro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParceiroRepository extends CrudRepository<Parceiro, Long> {
    Parceiro findById(long id);
    Parceiro findByCnpj(String cnpj);
    List<Parceiro> findByName(String nome);

    // QUERY QUE FARÁ A BUSCA NO BANCO DE DADOS
    @Query(value = "SELECT u FROM parceiros u WHERE u.nome_parceiro LIKE %?1%")
    List<Parceiro> findByNomesParceiros(String nome);
}
