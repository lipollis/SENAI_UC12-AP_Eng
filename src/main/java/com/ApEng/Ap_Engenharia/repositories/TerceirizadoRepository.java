package com.ApEng.Ap_Engenharia.repositories;

import com.ApEng.Ap_Engenharia.models.Projeto;
import com.ApEng.Ap_Engenharia.models.Terceirizado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TerceirizadoRepository extends CrudRepository<Terceirizado, Long> {
    Iterable<Terceirizado> findByProjeto(Projeto projeto);

    Terceirizado findById(long id);
    Terceirizado findByCnpj(String cnpj);
    List<Terceirizado> findByName(String nome);

    // QUERY QUE FARÁ A BUSCA NO BANCO DE DADOS
    @Query(value = "SELECT u FROM terceirizados u WHERE u.nome_terceirizado LIKE %?1%")
    List<Terceirizado> findByNomesTerceirizados(String nome);
}
