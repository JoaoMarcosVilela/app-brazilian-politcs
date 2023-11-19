package com.example.app_brazilian_politcs.modelos;

public class Eleitor extends Usuario {
    public Eleitor(String nome, String email, String senha, int telefone){
        super(nome,email,senha,telefone);
    }
    public Eleitor(String nome, String email, String senha){
        super(nome,email,senha);
    }
    public Eleitor(){
        super();
    }
}
