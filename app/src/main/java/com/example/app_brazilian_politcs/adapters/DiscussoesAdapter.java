package com.example.app_brazilian_politcs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.models.Discussao;
import com.example.app_brazilian_politcs.models.Noticia;

import java.util.List;

public class DiscussoesAdapter extends BaseAdapter {
    private Context context;
    private List<Discussao> discussoes;

    public DiscussoesAdapter(Context context, List<Discussao> discussoes) {
        this.context = context;
        this.discussoes = discussoes;
    }

    @Override
    public int getCount() {
        return discussoes.size();
    }

    @Override
    public Object getItem(int position) {
        return discussoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_discussao, parent, false);
        }

        TextView tituloDiscussao = convertView.findViewById(R.id.tituloDiscussaoTextView);

        Discussao discussao = discussoes.get(position);

        tituloDiscussao.setText(discussao.getTituloDiscussao());

        return convertView;

    }
}
