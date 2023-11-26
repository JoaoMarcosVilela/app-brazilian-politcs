package com.example.app_brazilian_politcs.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_jornalista")
public class Jornalista extends Usuario{

    public Jornalista(int id, String nome, String email, String senha, Long telefone) {
        super(id,nome, email, senha, telefone);
    }

}
