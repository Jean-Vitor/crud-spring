package com.example.sistema.repository;

import com.example.sistema.model.Comentario;
import com.example.sistema.model.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findAllByConteudo(Conteudo conteudo);
}
