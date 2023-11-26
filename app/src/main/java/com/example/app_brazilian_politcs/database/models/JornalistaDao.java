package com.example.app_brazilian_politcs.database.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app_brazilian_politcs.models.Eleitor;
import com.example.app_brazilian_politcs.models.Jornalista;

import java.util.List;

@Dao
public interface JornalistaDao {
    @Query("SELECT * FROM tabela_jornalista")
    List<Jornalista> getAll();

    @Query("SELECT * FROM tabela_jornalista WHERE nome LIKE :txtEmail AND senha LIKE :Senha")
    Jornalista findByEmailAndSenha(String txtEmail, Long Senha);

    @Insert
    void insert(Jornalista jornalista);

    @Insert
    void insertAll(List<Jornalista> jornalista);

    @Update
    void update(Jornalista jornalista);

    @Delete
    void delete(Jornalista jornalista);
}
