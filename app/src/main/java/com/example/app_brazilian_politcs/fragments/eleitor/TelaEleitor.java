package com.example.app_brazilian_politcs.fragments.eleitor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.databinding.FragmentTelaEleitorBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaEleitor extends Fragment {
    FragmentTelaEleitorBinding binding;
    private int i = 0;

    public TelaEleitor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaEleitorBinding.inflate(inflater,container,false);



        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                Date dataHoraAtual = new Date();
                String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                binding.textViewHora.setText(hora);
                handler.postDelayed(this, 10*100);
            }
        });

        return binding.getRoot();

    }
}