package com.example.a3novo;
import java.time.LocalDate;

public class Paciente {
    private String nome;
    private String numeroEmergencia;
    private LocalDate dataNascimento;
    private int idade;
    private double altura;
    private double peso;

    // Construtor
    public Paciente(String nome, String numeroEmergencia, LocalDate dataNascimento, int idade, double altura, double peso) {
        this.nome = nome;
        this.numeroEmergencia = numeroEmergencia;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}
