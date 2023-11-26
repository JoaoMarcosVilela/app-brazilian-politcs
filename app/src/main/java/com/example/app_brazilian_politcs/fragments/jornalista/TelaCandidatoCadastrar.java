package com.example.app_brazilian_politcs.fragments.jornalista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaCandidatoCadastrarBinding;
import com.example.app_brazilian_politcs.models.Candidato;
import com.google.android.material.snackbar.Snackbar;


public class TelaCandidatoCadastrar extends Fragment {
    FragmentTelaCandidatoCadastrarBinding binding;
    Database db;
    public TelaCandidatoCadastrar() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaCandidatoCadastrarBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();

        binding.btnEnivarCandidato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = binding.editTextNomeCandidato.getText().toString();
                String partido = binding.editTextPartido.getText().toString();

                if(!nome.isEmpty() && !partido.isEmpty()){
                    db.candidatoDao().insert(new Candidato(nome,partido));
                    Navigation.findNavController(v).navigate(R.id.telaCandidatosJornalista);
                }else{
                    Snackbar.make(v, "Nome e Partido. Obrigatórios", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }
            }
        });

        return binding.getRoot();
    }
}