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
import com.example.app_brazilian_politcs.databinding.FragmentTelaPrincipalDiscussaoCadastroBinding;
import com.example.app_brazilian_politcs.models.Discussao;
import com.google.android.material.snackbar.Snackbar;

public class TelaPrincipalDiscussaoCadastro extends Fragment {
    FragmentTelaPrincipalDiscussaoCadastroBinding binding;
    Database db;
    public TelaPrincipalDiscussaoCadastro() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaPrincipalDiscussaoCadastroBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();

        binding.btnEnviarDiscussao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = binding.editTextTituloDiscussao.getText().toString();
                String discussao = binding.editTextDiscussao.getText().toString();

                if(!titulo.isEmpty() && !discussao.isEmpty()){
                    db.discussaoDao().insert(new Discussao(titulo,discussao));
                    Navigation.findNavController(v).navigate(R.id.telaPrincipaisDiscussoesJornalista);
                }else{
                    Snackbar.make(v, "Título e Discussão. Obrigatórios", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }
            }
        });


        return binding.getRoot();
    }
}