package com.example.app_brazilian_politcs.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_noticias")
public class Noticia {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "titulo")
    private String titulo;
    @ColumnInfo(name = "sub_titulo")
    private String subtitulo;
    @ColumnInfo(name = "corpo_texto")
    private String corpoTexto;
    @ColumnInfo(name = "jonalista_responsavel")
    private String jornalistaResponsavel;

    public Noticia(String titulo, String subtitulo, String corpoTexto, String jornalistaResponsavel) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.corpoTexto = corpoTexto;
        this.jornalistaResponsavel = jornalistaResponsavel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getCorpoTexto() {
        return corpoTexto;
    }

    public void setCorpoTexto(String corpoTexto) {
        this.corpoTexto = corpoTexto;
    }

    public String getJornalistaResponsavel() {
        return jornalistaResponsavel;
    }

    public void setJornalistaResponsavel(String jornalistaResponsavel) {
        this.jornalistaResponsavel = jornalistaResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Título: "+ getTitulo()+
                "\nSubtitulo: "+ getSubtitulo();
    }
}
