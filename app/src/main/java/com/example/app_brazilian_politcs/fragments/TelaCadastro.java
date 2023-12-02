package com.example.app_brazilian_politcs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaCadastroBinding;
import com.example.app_brazilian_politcs.models.Eleitor;
import com.example.app_brazilian_politcs.models.Jornalista;
import com.google.android.material.snackbar.Snackbar;

public class TelaCadastro extends Fragment {
    FragmentTelaCadastroBinding binding;
    Database db;

    public TelaCadastro() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaCadastroBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();

        binding.toolbarTelaCadastro.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaPerguntaCadastro));

        binding.btnSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String condicao = getArguments().getString("controlador");
                String nome = binding.editTextNomeCadastro.getText().toString();
                String email = binding.editTextTextEmailTelaCadastro.getText().toString();
                String senha = binding.editTextSenhaCadastro.getText().toString();
                String telefone = binding.editTextTelefone.getText().toString();


                if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !telefone.isEmpty()){
                    if(condicao.equals("1")){
                        //cria o eleitor
                        db.eleitorDao().insert(new Eleitor(0,nome, email, senha, Long.parseLong(telefone)));
                        Navigation.findNavController(v).navigate(R.id.telaLogin);
                    }else if(condicao.equals("2")){
                        //criar o jornalista
                        Jornalista jornalista = new Jornalista(0,nome, email, senha, Long.parseLong(telefone));
                        db.jornalistaDao().insert(jornalista);
                        Navigation.findNavController(v).navigate(R.id.telaLogin);
                    }else{
                        //erro
                        Snackbar.make(v, "Erro ao cadastrar", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                        Navigation.findNavController(v).navigate(R.id.telaLogin);
                    }
                }else{
                    Snackbar.make(v, "Nome, email, senha e telefone. Obrigatórios", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }

            }
        });

        return binding.getRoot();
    }
}