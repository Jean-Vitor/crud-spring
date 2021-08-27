package com.example.sistema.service.implementation;
import com.example.sistema.model.Aluno;
import com.example.sistema.model.Conteudo;
import com.example.sistema.repository.AlunoRepository;
import com.example.sistema.repository.ConteudoRepository;
import com.example.sistema.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoServiceImpl implements ConteudoService {
    @Autowired
    ConteudoRepository conteudoRepository;

    @Override
    public void save(Conteudo conteudo) {
        conteudoRepository.save(conteudo);
    }

    @Override
    public Conteudo findById(long id) {
        return conteudoRepository.findById(id).get();
    }

    @Override
    public List<Conteudo> findAll () {
        return conteudoRepository.findAll();
    }

    @Override
    public void deleteById(long id) { conteudoRepository.deleteById(id); }
}
