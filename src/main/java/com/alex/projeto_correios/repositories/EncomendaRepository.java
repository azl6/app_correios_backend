package com.alex.projeto_correios.repositories;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {

    public Optional<Encomenda> findByCodigo(String codigo);
}
