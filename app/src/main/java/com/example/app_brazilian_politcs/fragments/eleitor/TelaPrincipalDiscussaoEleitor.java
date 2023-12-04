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
import com.example.app_brazilian_politcs.databinding.FragmentTelaPrincipalDiscussaoEleitorBinding;


public class TelaPrincipalDiscussaoEleitor extends Fragment {
    private FragmentTelaPrincipalDiscussaoEleitorBinding binding;
    private Database db;

    public TelaPrincipalDiscussaoEleitor() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaPrincipalDiscussaoEleitorBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        binding.tituloDiscussaoEleitorTextView.setText(getArguments().getString("tituloDiscussao"));
        binding.corpoDiscussaoTextView.setText(getArguments().getString("discussao"));

        binding.toolbarDiscussaoEleitor.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaPrincipaisDicussoesEleitor, bundle));

        return binding.getRoot();
    }
}