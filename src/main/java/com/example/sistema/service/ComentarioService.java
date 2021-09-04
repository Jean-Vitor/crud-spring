package com.example.sistema.service;

import com.example.sistema.model.Comentario;
import com.example.sistema.model.Conteudo;

import java.util.List;

public interface ComentarioService {
    void save(Comentario comentario);
    List<Comentario> findAllByConteudo(Conteudo conteudo);
    void deleteById(long id);
}
