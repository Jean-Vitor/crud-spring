package com.example.sistema.service;

import com.example.sistema.model.Aluno;

import java.util.List;

public interface AlunoService {
    void save(Aluno aluno);
    Aluno findById(long id);
    List<Aluno> findAll();
    void deleteById(long id);
}
