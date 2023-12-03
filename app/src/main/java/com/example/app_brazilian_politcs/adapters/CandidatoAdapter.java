package com.example.app_brazilian_politcs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.databinding.ItemCandidatoBinding;
import com.example.app_brazilian_politcs.models.Candidato;
import com.example.app_brazilian_politcs.models.Noticia;

import java.util.List;

public class CandidatoAdapter extends BaseAdapter {
    private Context context;
    private List<Candidato> candidatos;

    public CandidatoAdapter(Context context, List<Candidato> candidatos) {
        this.context = context;
        this.candidatos = candidatos;
    }

    @Override
    public int getCount() {
        return candidatos.size();
    }

    @Override
    public Object getItem(int position) {
        return candidatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_candidato, parent, false);
        }

        TextView nomeTextView = convertView.findViewById(R.id.nomeTextView);
        TextView partidoTextView = convertView.findViewById(R.id.partidoTextView);

        Candidato candidato = candidatos.get(position);

        nomeTextView.setText(candidato.getNome());
        partidoTextView.setText(candidato.getPartido());

        return convertView;
    }
}
