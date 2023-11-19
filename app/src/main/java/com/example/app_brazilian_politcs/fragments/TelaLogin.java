package com.example.app_brazilian_politcs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.databinding.FragmentTelaLoginBinding;

public class TelaLogin extends Fragment {
    FragmentTelaLoginBinding binding;
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

        //Fazer os casos para o tipo de acesso as contas
        binding.btnLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaLogin_to_telaEleitor));

        binding.bntCriarConta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaPerguntaCadastro));
        return binding.getRoot();
    }
}