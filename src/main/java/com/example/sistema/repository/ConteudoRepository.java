package com.example.sistema.repository;

import com.example.sistema.model.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

}
