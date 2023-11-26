package com.example.app_brazilian_politcs.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_eleitor")
public class Eleitor extends Usuario {


    public Eleitor(int id, String nome, String email, String senha, Long telefone) {
        super(id,nome, email, senha, telefone);
    }

    @Override
    public String toString() {
        return "Eleitor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
