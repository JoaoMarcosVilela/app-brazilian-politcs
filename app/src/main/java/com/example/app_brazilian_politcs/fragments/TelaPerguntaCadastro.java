package com.example.app_brazilian_politcs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.databinding.FragmentTelaPerguntaCadastroBinding;
import com.example.app_brazilian_politcs.modelos.Eleitor;

public class TelaPerguntaCadastro extends Fragment {
    FragmentTelaPerguntaCadastroBinding binding;

    public TelaPerguntaCadastro() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaPerguntaCadastroBinding.inflate(inflater,container,false);

        binding.btnEleitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String controlador = "1";
                bundle.putString("controlador",controlador);
                Navigation.findNavController(v).navigate(R.id.action_telaPerguntaCadastro_to_telaCadastro,bundle);
            }
        });
        binding.btnJornalista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String controlador = "2";
                bundle.putString("controlador",controlador);
                Navigation.findNavController(v).navigate(R.id.action_telaPerguntaCadastro_to_telaCadastro,bundle);
            }
        });

        return binding.getRoot();
    }
}