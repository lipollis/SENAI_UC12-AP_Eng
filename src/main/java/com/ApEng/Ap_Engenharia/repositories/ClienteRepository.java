package com.ApEng.Ap_Engenharia.repositories;

import com.ApEng.Ap_Engenharia.models.Cliente;
import com.ApEng.Ap_Engenharia.models.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Iterable<Cliente> findByProjeto(Projeto projeto);
    Cliente findById(long id);
    Cliente findByCpf(String cpf);
    List<Cliente> findByName(String nome);

    // QUERY QUE FARÁ A BUSCA NO BANCO DE DADOS
    @Query(value = "SELECT u FROM clientes u WHERE u.nome_cliente LIKE %?1%")
    List<Cliente> findByNomesClientes(String nome);
}
