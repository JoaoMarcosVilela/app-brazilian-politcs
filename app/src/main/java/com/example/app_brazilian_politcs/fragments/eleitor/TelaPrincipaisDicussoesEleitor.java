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
import com.example.app_brazilian_politcs.adapters.DiscussoesAdapter;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaPrincipaisDicussoesEleitorBinding;
import com.example.app_brazilian_politcs.models.Candidato;
import com.example.app_brazilian_politcs.models.Discussao;

import java.util.List;


public class TelaPrincipaisDicussoesEleitor extends Fragment {
    private FragmentTelaPrincipaisDicussoesEleitorBinding binding;
    private Database db;

    public TelaPrincipaisDicussoesEleitor() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaPrincipaisDicussoesEleitorBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));


        pegarDadosBd();
        listarDiscussoesDoListView();

        binding.listViewDiscussoesEleitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("usuario", getArguments().getString("usuario"));
                Discussao discussao = pegarDadosBd().get(position);
                bundle.putString("tituloDiscussao", discussao.getTituloDiscussao());
                bundle.putString("discussao", discussao.getDiscussao());
                Navigation.findNavController(view).navigate(R.id.action_telaPrincipaisDicussoesEleitor_to_telaPrincipalDiscussaoEleitor, bundle);
            }
        });

        binding.toolbarDiscussoesEleitor.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaEleitor, bundle));



        return binding.getRoot();
    }

    private void listarDiscussoesDoListView() {
        DiscussoesAdapter discussoesAdapter = new DiscussoesAdapter(getContext(), pegarDadosBd());
        binding.listViewDiscussoesEleitor.setAdapter(discussoesAdapter);
    }

    private List<Discussao> pegarDadosBd() {
        List<Discussao> discussoes;
        return discussoes = db.discussaoDao().getAll();
    }
}