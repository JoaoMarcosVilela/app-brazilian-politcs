package com.example.app_brazilian_politcs.database.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.app_brazilian_politcs.models.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuario WHERE nome like :txtNome")
    Usuario findByName(String txtNome);

    @Insert
    void insert(Usuario usuario);

    @Insert
    void insertAll(List<Usuario> usuarios);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);
}
