package com.ApEng.Ap_Engenharia.repositories;

import com.ApEng.Ap_Engenharia.models.Cliente;
import com.ApEng.Ap_Engenharia.models.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
    Iterable<Projeto> findByCliente(Cliente cliente);

    Projeto findById(long id);
    List<Projeto> findByName(String nome);

    // QUERY QUE FARÁ A BUSCA NO BANCO DE DADOS
    @Query(value = "SELECT u FROM projetos u WHERE u.nome_projeto LIKE %?1%")
    List<Projeto> findByNomesProjetos(String nome);
}
