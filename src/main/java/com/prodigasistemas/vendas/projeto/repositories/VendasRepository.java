package com.prodigasistemas.vendas.projeto.repositories;

import com.prodigasistemas.vendas.projeto.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Venda, String> {
}
