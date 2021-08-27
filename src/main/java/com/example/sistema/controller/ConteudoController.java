package com.example.sistema.controller;

import com.example.sistema.model.Aluno;
import com.example.sistema.model.Conteudo;
import com.example.sistema.service.AlunoService;
import com.example.sistema.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ConteudoController {
    @Autowired
    ConteudoService conteudoService;

    @Autowired
    AlunoService alunoService;

    @GetMapping("/conteudo/list")
    public ModelAndView getConteudos () {
        ModelAndView my = new ModelAndView("conteudos/list");
        List<Conteudo> conteudos = conteudoService.findAll();
        my.addObject("conteudos", conteudos);
        return my;
    }

    @GetMapping("/conteudo/form")
    public ModelAndView getConteudo () {
        ModelAndView my = new ModelAndView("conteudos/add");
        List<Aluno> alunos = alunoService.findAll();
        my.addObject("alunos", alunos);
        return my;
    }

    @PostMapping("/conteudo/salvar")
    public RedirectView postConteudo (@ModelAttribute("conteudo") Conteudo conteudo) {
        conteudo.setData(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        conteudoService.save(conteudo);
        return new RedirectView("/conteudo/list");
    }

    @GetMapping("/conteudo/editar/{id}")
    public ModelAndView getConteudo (@PathVariable("id") long id) {
        ModelAndView my = new ModelAndView("conteudos/edit");
        List<Aluno> alunos = alunoService.findAll();
        my.addObject("alunos", alunos);
        Conteudo conteudo = conteudoService.findById(id);
        my.addObject("conteudo", conteudo);
        return my;
    }

    @PostMapping("/conteudo/editar/{id}")
    public RedirectView editarConteudo (@ModelAttribute("conteudo") Conteudo conteudo, @PathVariable("id") long id) {
        Conteudo conteudoAtualizado = conteudoService.findById(id);
        conteudoAtualizado.setNome(conteudo.getNome());
        conteudoAtualizado.setDescricao(conteudo.getDescricao());
        conteudoAtualizado.setData(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        conteudoAtualizado.setAluno(conteudo.getAluno());
        conteudoService.save(conteudoAtualizado);
        return new RedirectView("/conteudo/list");
    }

    @PostMapping("/conteudo/deletar/{id}")
    public RedirectView deletarAluno (@PathVariable("id") long id) {
        conteudoService.deleteById(id);
        return new RedirectView("/conteudo/list");
    }
}
