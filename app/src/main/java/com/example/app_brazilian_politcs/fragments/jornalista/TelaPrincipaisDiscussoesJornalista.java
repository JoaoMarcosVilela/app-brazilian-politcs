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
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));
        binding.btnCadastrarDiscussoes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaPrincipaisDiscussoesJornalista_to_telaPrincipalDiscussaoCadastro,bundle));

        listarDadosDoListView();



        binding.toolbarTelaPrinciapaisDiscussoesJornalista.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaJornalista, bundle));

        binding.listViewPrincipaisDiscussoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Discussao discussao = pegarDadosBd().get(position);
                db.discussaoDao().delete(discussao);
                Toast.makeText(getContext(), discussao.getTituloDiscussao() + " Excluido", Toast.LENGTH_SHORT).show();
                listarDadosDoListView();
                return true;
            }
        });
        binding.listViewPrincipaisDiscussoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Discussao discussao = pegarDadosBd().get(position);
                Bundle bundle = new Bundle();
                bundle.putString("tituloDiscussao", discussao.getTituloDiscussao());
                bundle.putString("discussao", discussao.getDiscussao());
                bundle.putString("posissao", String.valueOf(position));
                Navigation.findNavController(view).navigate(R.id.action_telaPrincipaisDiscussoesJornalista_to_telaPrincipalDiscussaoCadastro, bundle);
            }
        });

        return binding.getRoot();
    }
    public List<Discussao> pegarDadosBd(){
        List<Discussao> discussoes;
        return discussoes = db.discussaoDao().getAll();
    }
    public void listarDadosDoListView(){
        ArrayList<String> dados = new ArrayList<>();
        for(Discussao i: pegarDadosBd()){
            dados.add(i.toString());
        }
        ArrayAdapter adapter = new ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dados);
        binding.listViewPrincipaisDiscussoes.setAdapter(adapter);
    }
}