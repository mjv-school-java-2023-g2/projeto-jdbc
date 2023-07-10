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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCargaHoraria(LocalTime cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public void setEstrangeiro(boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    public void setHorasDisponiveis(Integer horasDisponiveis) {
        this.horasDisponiveis = horasDisponiveis;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }
}
