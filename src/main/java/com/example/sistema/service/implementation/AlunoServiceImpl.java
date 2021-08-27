package com.example.sistema.service.implementation;
import com.example.sistema.model.Aluno;
import com.example.sistema.repository.AlunoRepository;
import com.example.sistema.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public void save(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public Aluno findById(long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> findAll () {
        return alunoRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        alunoRepository.deleteById(id);
    }
}
