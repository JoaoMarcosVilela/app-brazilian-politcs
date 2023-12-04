package com.example.app_brazilian_politcs.fragments.eleitor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaNoticiaCompletaBinding;


public class TelaNoticiaCompleta extends Fragment {
    private FragmentTelaNoticiaCompletaBinding binding;
    private Database db;

    public TelaNoticiaCompleta() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaNoticiaCompletaBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        binding.TituloNoticiaTextView.setText(getArguments().getString("tituloNoticia"));
        binding.subtituloNoticiaTextView.setText(getArguments().getString("subTituloNoticia"));
        binding.textoNoticiaTextView.setText(getArguments().getString("corpoNoticia"));


        binding.toolbarNoticiaCompleta.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaNoticiasEleitor, bundle));

        return binding.getRoot();
    }
}