package com.example.sistema.controller;

import com.example.sistema.model.Comentario;
import com.example.sistema.model.Conteudo;
import com.example.sistema.service.ComentarioService;
import com.example.sistema.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ComentarioController {
    @Autowired
    ConteudoService conteudoService;

    @Autowired
    ComentarioService comentarioService;

    @PostMapping("/comentario/salvar/{id}")
    public RedirectView salvarComentario (@RequestParam("texto") String texto, @PathVariable("id") long id) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Conteudo conteudo = conteudoService.findById(id);
        Comentario comentario = new Comentario(texto, conteudo);
        comentarioService.save(comentario);
        return new RedirectView("/detalhes/" + id);
    }
}
