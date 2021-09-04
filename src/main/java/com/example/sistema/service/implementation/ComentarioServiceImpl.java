package com.example.sistema.service.implementation;

import com.example.sistema.model.Comentario;
import com.example.sistema.model.Conteudo;
import com.example.sistema.repository.ComentarioRepository;
import com.example.sistema.repository.ConteudoRepository;
import com.example.sistema.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public void save(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public List<Comentario> findAllByConteudo(Conteudo conteudo) {
        return comentarioRepository.findAllByConteudo(conteudo);
    }

    @Override
    public void deleteById(long id) {
        comentarioRepository.deleteById(id);
    }
}
