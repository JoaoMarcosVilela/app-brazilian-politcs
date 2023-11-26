package com.example.app_brazilian_politcs.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_candidato")
public class Candidato {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "partido")
    private String partido;
    public Candidato(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPartido() {
        return partido;
    }
    public void setPartido(String partido) {
        this.partido = partido;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNome()+"\n "+ getPartido();
    }
}
