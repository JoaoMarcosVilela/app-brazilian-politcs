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
import com.example.app_brazilian_politcs.databinding.FragmentTelaCandidatoEleitorBinding;

public class TelaCandidatoEleitor extends Fragment {
    private FragmentTelaCandidatoEleitorBinding binding;
    private Database db;


    public TelaCandidatoEleitor() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaCandidatoEleitorBinding.inflate(inflater,container,false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();
        Bundle bundle = new Bundle();
        bundle.putString("usuario", getArguments().getString("usuario"));

        binding.nomeCandidatoTextView.setText(getArguments().getString("nomeCandidato"));
        binding.PartidoTextView.setText(getArguments().getString("partidoCandidato"));

        binding.toolbarCandidato.setNavigationOnClickListener(Navigation.createNavigateOnClickListener(R.id.telaCandidatosEleitor, bundle));

        return binding.getRoot();
    }
}