package com.example.app_brazilian_politcs.fragments.jornalista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaCandidatosJornalistaBinding;
import com.example.app_brazilian_politcs.models.Candidato;

import java.util.ArrayList;
import java.util.List;

public class TelaCandidatosJornalista extends Fragment {
    FragmentTelaCandidatosJornalistaBinding binding;
    Database db;
    public TelaCandidatosJornalista() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaCandidatosJornalistaBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();

        binding.btnCadastrarCandidatos.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaCandidatosJornalista_to_telaCandidatoCadastrar));

        List<Candidato> candidatos = db.candidatoDao().getAll();
        ArrayList<String> dados = new ArrayList<>();
        for(Candidato i: candidatos){
            dados.add(i.toString());
        }
        ArrayAdapter adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, dados);
        binding.listViewCandidatos.setAdapter(adapter);

        return binding.getRoot();
    }
}