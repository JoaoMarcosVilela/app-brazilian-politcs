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

        if(getArguments().getString("posissao") != null){
            String nome = getArguments().getString("nome");
            String partido = getArguments().getString("partido");

            binding.editTextNomeCandidato.setText(nome);
            binding.editTextPartido.setText(partido);

            binding.btnEnivarCandidato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String novoNome = binding.editTextNomeCandidato.getText().toString();
                    String novoPartido = binding.editTextPartido.getText().toString();

                    Candidato candidato = db.candidatoDao().findByNome(nome);
                    candidato.setNome(novoNome);
                    candidato.setPartido(novoPartido);
                    db.candidatoDao().update(candidato);
                    Bundle bundle = new Bundle();
                    bundle.putString("usuario",getArguments().getString("usuario"));
                    Navigation.findNavController(v).navigate(R.id.telaCandidatosJornalista, bundle);
                }
            });
        }else{
            binding.btnEnivarCandidato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nome = binding.editTextNomeCandidato.getText().toString();
                    String partido = binding.editTextPartido.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("usuario", getArguments().getString("usuario"));

                    if(!nome.isEmpty() && !partido.isEmpty()){
                        db.candidatoDao().insert(new Candidato(nome,partido));
                        Navigation.findNavController(v).navigate(R.id.telaCandidatosJornalista,bundle);
                    }else{
                        Snackbar.make(v, "Nome e Partido. Obrigatórios", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                    }
                }
            });
        }



        return binding.getRoot();
    }
}