package com.example.app_brazilian_politcs.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_discussao")
public class Discussao {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "titulo")
    private String tituloDiscussao;
    @ColumnInfo(name = "discussao")
    private String discussao;

    public Discussao(String tituloDiscussao, String discussao) {
        this.tituloDiscussao = tituloDiscussao;
        this.discussao = discussao;
    }

    public String getTituloDiscussao() {
        return tituloDiscussao;
    }

    public void setTituloDiscussao(String tituloDiscussao) {
        this.tituloDiscussao = tituloDiscussao;
    }

    public String getDiscussao() {
        return discussao;
    }

    public void setDiscussao(String discussao) {
        this.discussao = discussao;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getTituloDiscussao();
    }
}
