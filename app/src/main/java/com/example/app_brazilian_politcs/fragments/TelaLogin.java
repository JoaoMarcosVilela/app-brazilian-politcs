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
import com.example.app_brazilian_politcs.databinding.FragmentTelaLoginBinding;
import com.example.app_brazilian_politcs.models.Eleitor;
import com.example.app_brazilian_politcs.models.Jornalista;
import com.example.app_brazilian_politcs.models.Usuario;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class TelaLogin extends Fragment {
    private FragmentTelaLoginBinding binding;
    private Database db;
    public TelaLogin() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaLoginBinding.inflate(inflater,container,false);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editTextTextEmailAddress.getText().toString();
                String senha = binding.editTextSenhaTelaLogin.getText().toString();
                db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
                Bundle bundle = new Bundle();

                if(!email.isEmpty() && !binding.editTextSenhaTelaLogin.getText().toString().isEmpty()){
                    List<Eleitor> eleitores = db.eleitorDao().getAll();
                    List<Jornalista> jornalistas = db.jornalistaDao().getAll();
                    boolean achouEleitor = false;
                    boolean achouJornalista = false;
                    boolean controlador = true;

                    while (controlador) {
                        for (Usuario i : eleitores) {
                            if (i.getEmail().equals(email) && i.getSenha().equals(senha)) {
                                achouEleitor = true;
                                bundle.putString("usuario", i.getNome());
                                controlador = false;
                                break;
                            }
                        }
                        for (Usuario i : jornalistas) {
                            if (i.getEmail().equals(email) && i.getSenha().equals(senha)) {
                                achouJornalista = true;
                                bundle.putString("usuario", i.getNome());
                                controlador = false;
                                break;
                            }
                        }
                        controlador = false;
                    }
                    if(achouEleitor == true){
                        Navigation.findNavController(v).navigate(R.id.action_telaLogin_to_telaEleitor,bundle);
                    }else if(achouJornalista == true){
                        Navigation.findNavController(v).navigate(R.id.action_telaLogin_to_telaJornalista,bundle);
                    }else {
                        Snackbar.make(v, "Senha ou usuário Incorreto", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                    }
                }else {
                    Snackbar.make(v, "Por favor, preencha todos os campos", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }
            }
        });

        binding.bntCriarConta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaPerguntaCadastro));
        return binding.getRoot();
    }

}