package org.group2.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Professor {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalTime cargaHoraria;
    private BigDecimal valorHora;
    private boolean estrangeiro;
    private Integer horasDisponiveis;
    private String biografia;
    private LocalDateTime dataHoraCadastro;

    public Professor(int id, String nome, LocalDate dataNascimento, LocalTime cargaHoraria, BigDecimal valorHora,
                     boolean estrangeiro, Integer horasDisponiveis, String biografia,
                     LocalDateTime dataHoraCadastro) {
        this.id = id;               
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cargaHoraria = cargaHoraria;
        this.valorHora = valorHora;
        this.estrangeiro = estrangeiro;
        this.horasDisponiveis = horasDisponiveis;
        this.biografia = biografia;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Professor(String nome, LocalDate dataNascimento, LocalTime cargaHoraria, BigDecimal valorHora,
                     boolean estrangeiro, Integer horasDisponiveis, String biografia,
                     LocalDateTime dataHoraCadastro) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cargaHoraria = cargaHoraria;
        this.valorHora = valorHora;
        this.estrangeiro = estrangeiro;
        this.horasDisponiveis = horasDisponiveis;
        this.biografia = biografia;
        this.dataHoraCadastro = dataHoraCadastro;
    }
    public Integer getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public LocalTime getCargaHoraria() {
        return cargaHoraria;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public boolean isEstrangeiro() {
        return estrangeiro;
    }

    public Integer getHorasDisponiveis() {
        return horasDisponiveis;
    }

    public String getBiografia() {
        return biografia;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }


}
