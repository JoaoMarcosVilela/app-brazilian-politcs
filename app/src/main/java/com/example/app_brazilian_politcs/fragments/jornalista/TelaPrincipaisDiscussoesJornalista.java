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
import com.example.app_brazilian_politcs.databinding.FragmentTelaPrincipaisDiscussoesJornalistaBinding;
import com.example.app_brazilian_politcs.models.Discussao;

import java.util.ArrayList;
import java.util.List;


public class TelaPrincipaisDiscussoesJornalista extends Fragment {
    FragmentTelaPrincipaisDiscussoesJornalistaBinding binding;
    Database db;

    public TelaPrincipaisDiscussoesJornalista() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaPrincipaisDiscussoesJornalistaBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();

        binding.btnCadastrarDiscussoes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaPrincipaisDiscussoesJornalista_to_telaPrincipalDiscussaoCadastro));

        List<Discussao> discussoes = db.discussaoDao().getAll();
        ArrayList<String> dados = new ArrayList<>();
        for(Discussao i: discussoes){
            dados.add(i.toString());
        }
        ArrayAdapter adapter = new ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dados);
        binding.listViewPrincipaisDiscussoes.setAdapter(adapter);

        return binding.getRoot();
    }
}