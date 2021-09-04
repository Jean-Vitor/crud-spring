package com.example.sistema.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    private String texto;

    @ManyToOne
    @JoinColumn(name = "conteudo_id")
    private Conteudo conteudo;

    public Comentario(String texto, Conteudo conteudo) {
        this.texto = texto;
        this.conteudo = conteudo;
    }

    public Comentario() {

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }
}
