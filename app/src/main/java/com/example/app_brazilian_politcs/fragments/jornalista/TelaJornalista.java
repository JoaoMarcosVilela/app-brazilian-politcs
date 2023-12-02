package com.example.app_brazilian_politcs.fragments.jornalista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaEleitorBinding;
import com.example.app_brazilian_politcs.databinding.FragmentTelaJornalistaBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaJornalista extends Fragment {
    FragmentTelaJornalistaBinding binding;
    Database db;

    public TelaJornalista() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaJornalistaBinding.inflate(inflater,container,false);

        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        binding.textViewUsuarioJornalista.setText(getArguments().getString("usuario"));
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        binding.btnCadastrarNoticiasJornalista.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaJornalista_to_telaNoticiasJornalista,bundle));
        binding.btnCadastrarCandidatosJornalista.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaJornalista_to_telaCandidatosJornalista, bundle));
        binding.btnCadastrarDiscussoesJornalista.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaJornalista_to_telaPrincipaisDiscussoesJornalista, bundle));
        binding.btnSairJornalista.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaInicial));

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                Date dataHoraAtual = new Date();
                String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                binding.textViewHoraJornalista.setText(hora);
                handler.postDelayed(this, 10*100);
            }
        });

        return binding.getRoot();
    }
}