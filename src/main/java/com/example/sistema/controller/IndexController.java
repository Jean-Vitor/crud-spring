package com.example.sistema.controller;

import com.example.sistema.model.Conteudo;
import com.example.sistema.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ConteudoService conteudoService;

    @GetMapping("/")
    public ModelAndView index () {
        ModelAndView my = new ModelAndView("index");
        List<Conteudo> conteudos = conteudoService.findAll();
        my.addObject("conteudos", conteudos);
        return my;
    }
}
