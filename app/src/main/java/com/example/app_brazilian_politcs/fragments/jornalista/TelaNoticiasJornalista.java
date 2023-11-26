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
import com.example.app_brazilian_politcs.databinding.FragmentTelaNoticiasJornalistaBinding;
import com.example.app_brazilian_politcs.models.Noticia;

import java.util.ArrayList;
import java.util.List;

public class TelaNoticiasJornalista extends Fragment {
    FragmentTelaNoticiasJornalistaBinding binding;
    Database db;
    public TelaNoticiasJornalista() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaNoticiasJornalistaBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        List<Noticia> noticias = db.noticiaDao().getAll();
        ArrayList<String> dados = new ArrayList<>();

        for(Noticia i: noticias){
            dados.add(i.toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,dados);
        binding.listViewNoticias.setAdapter(adapter);


        binding.btnCadastrarNoticia.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaNoticiasJornalista_to_telaNoticiaCadastro, bundle));

        return binding.getRoot();
    }
}