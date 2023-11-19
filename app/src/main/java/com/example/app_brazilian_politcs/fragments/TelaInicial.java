package com.example.app_brazilian_politcs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.databinding.FragmentTelaInicialBinding;

public class TelaInicial extends Fragment {
    FragmentTelaInicialBinding binding;

    public TelaInicial() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaInicialBinding.inflate(inflater,container,false);

        binding.btnLoginTelaInicial.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaInicial_to_telaLogin));
        binding.btnCadastrar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaInicial_to_telaPerguntaCadastro));

        return binding.getRoot();
    }
}