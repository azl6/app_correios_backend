package com.alex.projeto_correios.repositories;

import com.alex.projeto_correios.domain.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {
}
