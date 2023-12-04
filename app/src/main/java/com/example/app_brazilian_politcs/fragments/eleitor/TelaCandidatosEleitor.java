package com.example.app_brazilian_politcs.fragments.eleitor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.adapters.CandidatoAdapter;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaCandidatosEleitorBinding;
import com.example.app_brazilian_politcs.models.Candidato;

import java.util.List;


public class TelaCandidatosEleitor extends Fragment {
    private FragmentTelaCandidatosEleitorBinding binding;
    private Database db;

    public TelaCandidatosEleitor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaCandidatosEleitorBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        pegarDadosBd();
        listarCandidatosDoListView();

        binding.toolbarCandidatoEleitor.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaEleitor, bundle));

        binding.listViewCandidatosEleitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("usuario", getArguments().getString("usuario"));
                Candidato candidato = pegarDadosBd().get(position);
                bundle.putString("nomeCandidato", candidato.getNome());
                bundle.putString("partidoCandidato", candidato.getPartido());
                Navigation.findNavController(view).navigate(R.id.action_telaCandidatosEleitor_to_telaCandidatoEleitor, bundle);
            }
        });

        return binding.getRoot();
    }

    private void listarCandidatosDoListView() {
        CandidatoAdapter candidatoAdapter = new CandidatoAdapter(getContext(), pegarDadosBd());
        binding.listViewCandidatosEleitor.setAdapter(candidatoAdapter);
    }

    private List<Candidato> pegarDadosBd() {
        List<Candidato> candidatos;
        return candidatos = db.candidatoDao().getAll();
    }
}