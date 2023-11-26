package com.example.app_brazilian_politcs.database.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app_brazilian_politcs.models.Candidato;
import com.example.app_brazilian_politcs.models.Jornalista;

import java.util.List;

@Dao
public interface CandidatoDao {
    @Query("SELECT * FROM tabela_candidato")
    List<Candidato> getAll();

    @Query("SELECT * FROM tabela_candidato WHERE nome LIKE :nome")
    Candidato findByNome(String nome);

    @Insert
    void insert(Candidato candidato);

    @Insert
    void insertAll(List<Candidato> candidato);

    @Update
    void update(Candidato candidato);

    @Delete
    void delete(Candidato candidato);
}
