package com.example.app_brazilian_politcs.database.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app_brazilian_politcs.models.Jornalista;
import com.example.app_brazilian_politcs.models.Noticia;

import java.util.List;

@Dao
public interface NoticiaDao {
    @Query("SELECT * FROM tabela_noticias")
    List<Noticia> getAll();

    @Query("SELECT * FROM tabela_noticias WHERE titulo LIKE :titulo")
    Noticia findByTitulo(String titulo);

    @Insert
    void insert(Noticia noticia);

    @Insert
    void insertAll(List<Noticia> noticia);

    @Update
    void update(Noticia noticia);

    @Delete
    void delete(Noticia noticia);
}
