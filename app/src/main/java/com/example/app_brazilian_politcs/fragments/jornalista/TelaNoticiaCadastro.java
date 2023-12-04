package com.example.app_brazilian_politcs.fragments.jornalista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.database.Database;
import com.example.app_brazilian_politcs.databinding.FragmentTelaNoticiaCadastroBinding;
import com.example.app_brazilian_politcs.models.Noticia;
import com.google.android.material.snackbar.Snackbar;

public class TelaNoticiaCadastro extends Fragment {
    private FragmentTelaNoticiaCadastroBinding binding;
    private Database db;

    public TelaNoticiaCadastro() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaNoticiaCadastroBinding.inflate(inflater,container, false);
        db = Room.databaseBuilder(requireContext(), Database.class, "EducaPol").allowMainThreadQueries().build();

        if(getArguments().getString("posisao") != null) {

            String titulo = getArguments().getString("titulo");
            String subtitulo = getArguments().getString("subTitulo");
            String corpoTexto = getArguments().getString("corpoTexto");
            String jornalista = getArguments().getString("usuario");

            binding.editTextTitulo.setText(titulo);
            binding.editTextSubTitulo.setText(subtitulo);
            binding.editTextCorpoTexto.setText(corpoTexto);
            binding.btnEnviarNoticia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String novoTitulo = binding.editTextTitulo.getText().toString();
                    String novoSubTitulo = binding.editTextSubTitulo.getText().toString();
                    String novoCorpoTexto = binding.editTextCorpoTexto.getText().toString();

                    Bundle bundle = new Bundle();
                    bundle.putString("usuario", jornalista);

                    Noticia noticia = db.noticiaDao().findByTitulo(titulo);
                    noticia.setTitulo(novoTitulo);
                    noticia.setSubtitulo(novoSubTitulo);
                    noticia.setCorpoTexto(novoCorpoTexto);
                    db.noticiaDao().update(noticia);
                    Navigation.findNavController(v).navigate(R.id.telaNoticiasJornalista, bundle);
                }
            });
        }else {
            binding.btnEnviarNoticia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String titulo = binding.editTextTitulo.getText().toString();
                    String subtitlo = binding.editTextSubTitulo.getText().toString();
                    String corpoNoticia = binding.editTextCorpoTexto.getText().toString();
                    String usuario = getArguments().getString("usuario");

                    if (!titulo.isEmpty() && !subtitlo.isEmpty() && !corpoNoticia.isEmpty()) {
                        db.noticiaDao().insert(new Noticia(titulo, subtitlo, corpoNoticia, usuario));
                        Bundle bundle = new Bundle();
                        bundle.putString("usuario", usuario);
                        Navigation.findNavController(v).navigate(R.id.telaJornalista, bundle);
                    } else {
                        Snackbar.make(v, "Título, subtitlo e Reportagem. Obrigatórios", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                    }
                }
            });
        }
        return binding.getRoot();
    }
}