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

                int horaAtual = Integer.parseInt(new SimpleDateFormat("HH").format(dataHoraAtual));
                String cumprimento = realizarVerificacoes(horaAtual);
                binding.textViewHorarioJornalista.setText(cumprimento);

                handler.postDelayed(this, 10*100);
            }
        });

        return binding.getRoot();
    }

    private String realizarVerificacoes(int horaAtual) {
        if (horaAtual >= 5 && horaAtual < 12) {
            binding.imageViewHorarioJornalista.setImageResource(R.drawable.bom_dia);
            return "Bom dia";
        } else if (horaAtual >= 12 && horaAtual < 18) {
            binding.imageViewHorarioJornalista.setImageResource(R.drawable.boa_tarde);
            return "Boa tarde";
        } else {
            binding.imageViewHorarioJornalista.setImageResource(R.drawable.boa_noite);
            return "Boa noite";
        }
    }

}