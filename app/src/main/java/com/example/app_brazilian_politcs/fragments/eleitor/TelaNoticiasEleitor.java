package com.example.app_brazilian_politcs.fragments.eleitor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaNoticiasEleitorBinding;
import com.example.app_brazilian_politcs.models.Noticia;
import com.example.app_brazilian_politcs.adapters.NoticiaAdapter;

import java.util.List;

public class TelaNoticiasEleitor extends Fragment {
    FragmentTelaNoticiasEleitorBinding binding;
    Database db;

    public TelaNoticiasEleitor() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaNoticiasEleitorBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        pegarDadosBd();
        listarNoticiasDoListView();

        binding.listViewNoticiasEleitor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("usuario", getArguments().getString("usuario"));
                Noticia noticia = pegarDadosBd().get(position);
                bundle.putString("tituloNoticia", noticia.getTitulo());
                bundle.putString("subTituloNoticia", noticia.getSubtitulo());
                bundle.putString("corpoNoticia", noticia.getCorpoTexto());
                Navigation.findNavController(view).navigate(R.id.action_telaNoticiasEleitor_to_telaNoticiaCompleta, bundle);
            }
        });

        binding.toolbarNoticiasEleitor.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaEleitor, bundle));

        return binding.getRoot();
    }

    public List<Noticia> pegarDadosBd(){
        List<Noticia> noticia;
        return noticia = db.noticiaDao().getAll();
    }

    public void listarNoticiasDoListView(){
        NoticiaAdapter noticiaAdapter = new NoticiaAdapter(getContext(), pegarDadosBd());
        binding.listViewNoticiasEleitor.setAdapter(noticiaAdapter);
    }
}