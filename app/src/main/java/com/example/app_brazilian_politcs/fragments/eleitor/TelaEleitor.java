package com.example.app_brazilian_politcs.fragments.eleitor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaEleitorBinding;
import com.example.app_brazilian_politcs.models.Eleitor;
import com.example.app_brazilian_politcs.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaEleitor extends Fragment {
    FragmentTelaEleitorBinding binding;
    Database db;
    private int i = 0;

    public TelaEleitor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaEleitorBinding.inflate(inflater,container,false);

        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        binding.textViewUsuarioEleitor.setText(getArguments().getString("usuario"));
        Bundle bundle = new Bundle();
        bundle.putString("usuario",getArguments().getString("usuario"));


        binding.btnNoticiasTelaEleitor.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaEleitor_to_telaNoticiasEleitor,bundle));
        binding.btnCandidatosTelaEleitor.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaEleitor_to_telaCandidatosEleitor,bundle));
        binding.btnDiscussoesEleitor.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaEleitor_to_telaPrincipaisDicussoesEleitor,bundle));
        binding.btnSairEleitor.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaInicial));


        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                Date dataHoraAtual = new Date();
                String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                binding.textViewHoraEleitor.setText(hora);
                handler.postDelayed(this, 10*100);
            }
        });

        return binding.getRoot();

    }
}