package com.example.app_brazilian_politcs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_brazilian_politcs.R;
import com.example.app_brazilian_politcs.models.Noticia;

import java.util.List;

public class NoticiaAdapter extends BaseAdapter {

    private Context context;
    private List<Noticia> noticias;

    public NoticiaAdapter(Context context, List<Noticia> noticias) {
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int position) {
        return noticias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_noticia, parent, false);
        }

        TextView tituloTextView = convertView.findViewById(R.id.tituloTextView);
        TextView subtituloTextView = convertView.findViewById(R.id.subtituloTextView);

        Noticia noticia = noticias.get(position);

        tituloTextView.setText(noticia.getTitulo());
        subtituloTextView.setText(noticia.getSubtitulo());

        return convertView;
    }
}
