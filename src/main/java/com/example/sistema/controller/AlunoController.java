package com.example.sistema.controller;

import com.example.sistema.model.Aluno;
import com.example.sistema.repository.AlunoRepository;
import com.example.sistema.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @GetMapping("/aluno/list")
    public ModelAndView getAlunos () {
        ModelAndView my = new ModelAndView("alunos/list");
        List<Aluno> alunos = alunoService.findAll();
        my.addObject("alunos", alunos);
        return my;
    }

    @GetMapping("/aluno/form")
    public String getAluno () {
        return "alunos/add";
    }

    @PostMapping("/aluno/salvar")
    public RedirectView postAluno (@ModelAttribute("aluno") Aluno aluno) {
        alunoService.save(aluno);
        return new RedirectView("/aluno/list");
    }

    @GetMapping("/aluno/editar/{id}")
    public ModelAndView getAluno (@PathVariable("id") long id) {
        ModelAndView my = new ModelAndView("alunos/edit");
        Aluno aluno = alunoService.findById(id);
        my.addObject("aluno", aluno);
        return my;
    }

    @PostMapping("/aluno/editar/{id}")
    public RedirectView editarAluno (@ModelAttribute("aluno") Aluno aluno, @PathVariable("id") long id) {
        Aluno alunoAtualizado = alunoService.findById(id);
        alunoAtualizado.setNome(aluno.getNome());
        alunoAtualizado.setAno(aluno.getAno());
        alunoAtualizado.setTurma(aluno.getTurma());
        alunoService.save(alunoAtualizado);
        return new RedirectView("/aluno/list");
    }

    @PostMapping("/aluno/deletar/{id}")
    public RedirectView deletarAluno (@PathVariable("id") long id) {
        alunoService.deleteById(id);
        return new RedirectView("/aluno/list");
    }
}
