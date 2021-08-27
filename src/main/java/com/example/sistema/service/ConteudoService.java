package com.example.sistema.service;

import com.example.sistema.model.Conteudo;

import java.util.List;

public interface ConteudoService {
    void save(Conteudo conteudo);
    Conteudo findById(long id);
    List<Conteudo> findAll();
    void deleteById(long id);
}
