package com.example.app_brazilian_politcs.modelos;

public abstract class Usuario {
    private String nome, email, senha;
    private int telefone;

    protected Usuario(String nome, String email, String senha, int telefone){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
    protected Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    protected Usuario(){

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getTelefone() {
        return telefone;
    }

}
