package com.example.app_brazilian_politcs.fragments.jornalista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        binding.btnCadastrarCandidatos.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaCandidatosJornalista_to_telaCandidatoCadastrar, bundle));
        listarDadosDoListView();



        binding.toolbarTelaCandidatosJornalista.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaJornalista, bundle));

        binding.listViewCandidatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Candidato candidato = pegarDadosBd().get(position);
                db.candidatoDao().delete(candidato);
                Toast.makeText(getContext(), candidato.getNome() + " Excluido", Toast.LENGTH_SHORT).show();
                listarDadosDoListView();
                return true;
            }
        });

        binding.listViewCandidatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Candidato candidato = pegarDadosBd().get(position);
                Bundle bundle = new Bundle();
                bundle.putString("nome", candidato.getNome());
                bundle.putString("partido", candidato.getPartido());
                bundle.putString("usuario", getArguments().getString("usuario"));
                bundle.putString("posissao", String.valueOf(position));
                Navigation.findNavController(view).navigate(R.id.action_telaCandidatosJornalista_to_telaCandidatoCadastrar, bundle);
            }
        });


        return binding.getRoot();
    }

    public List<Candidato> pegarDadosBd(){
        List<Candidato> candidatos;
        return candidatos = db.candidatoDao().getAll();
    }
    public void listarDadosDoListView(){
        ArrayList<String> dados = new ArrayList<>();
        for(Candidato i: pegarDadosBd()){
            dados.add(i.toString());
        }
        ArrayAdapter adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, dados);
        binding.listViewCandidatos.setAdapter(adapter);
    }
}