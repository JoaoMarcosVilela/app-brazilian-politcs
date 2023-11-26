package com.example.app_brazilian_politcs.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app_brazilian_politcs.database.models.CandidatoDao;
import com.example.app_brazilian_politcs.database.models.DiscussaoDao;
import com.example.app_brazilian_politcs.database.models.EleitorDao;
import com.example.app_brazilian_politcs.database.models.JornalistaDao;
import com.example.app_brazilian_politcs.database.models.NoticiaDao;
import com.example.app_brazilian_politcs.models.Candidato;
import com.example.app_brazilian_politcs.models.Discussao;
import com.example.app_brazilian_politcs.models.Eleitor;
import com.example.app_brazilian_politcs.models.Jornalista;
import com.example.app_brazilian_politcs.models.Noticia;
import com.example.app_brazilian_politcs.models.Usuario;

@androidx.room.Database(entities = {Usuario.class, Eleitor.class,
        Jornalista.class, Noticia.class, Candidato.class, Discussao.class},
        version = 2)
public abstract class Database extends RoomDatabase {
    public abstract EleitorDao eleitorDao();
    public  abstract JornalistaDao jornalistaDao();

    public abstract NoticiaDao noticiaDao();

    public abstract CandidatoDao candidatoDao();

    public abstract DiscussaoDao discussaoDao();

}
