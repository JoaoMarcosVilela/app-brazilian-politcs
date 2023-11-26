package com.example.app_brazilian_politcs.database.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app_brazilian_politcs.models.Discussao;
import com.example.app_brazilian_politcs.models.Jornalista;

import java.util.List;

@Dao
public interface DiscussaoDao {
    @Query("SELECT * FROM tabela_discussao")
    List<Discussao> getAll();

    @Query("SELECT * FROM tabela_discussao WHERE titulo LIKE :titulo")
    Discussao findByTitulo(String titulo);

    @Insert
    void insert(Discussao discussao);

    @Insert
    void insertAll(List<Discussao> discussao);

    @Update
    void update(Discussao discussao);

    @Delete
    void delete(Discussao discussao);
}
