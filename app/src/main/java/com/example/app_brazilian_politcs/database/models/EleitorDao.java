package com.example.app_brazilian_politcs.database.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app_brazilian_politcs.models.Eleitor;

import java.util.List;

@Dao
public interface EleitorDao {
    @Query("SELECT * FROM tabela_eleitor")
    List<Eleitor> getAll();

    @Query("SELECT * FROM tabela_eleitor WHERE nome LIKE :txtEmail AND senha LIKE :Senha")
    Eleitor findByEmailAndSenha(String txtEmail, Long Senha);


    @Insert
    void insert(Eleitor eleitor);

    @Insert
    void insertAll(List<Eleitor> eleitor);

    @Update
    void update(Eleitor eleitor);

    @Delete
    void delete(Eleitor eleitor);
}
