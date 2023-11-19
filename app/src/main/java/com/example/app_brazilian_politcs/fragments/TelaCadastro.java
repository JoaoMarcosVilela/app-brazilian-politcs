package com.example.app_brazilian_politcs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.databinding.FragmentTelaCadastroBinding;

public class TelaCadastro extends Fragment {
    FragmentTelaCadastroBinding binding;

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

        binding.btnSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String condicao = getArguments().getString("controlador");
                if(condicao.equals("1")){
                    //cria o eleitor
                    Navigation.findNavController(v).navigate(R.id.telaLogin);
                }else if(condicao.equals("2")){
                    //cria
                    Navigation.findNavController(v).navigate(R.id.telaLogin);
                }else{
                    //erro
                    Navigation.findNavController(v).navigate(R.id.telaLogin);
                }
            }
        });

        return binding.getRoot();
    }
}