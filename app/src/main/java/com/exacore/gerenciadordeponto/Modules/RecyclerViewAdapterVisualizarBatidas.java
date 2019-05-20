package com.exacore.gerenciadordeponto.Modules;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.exacore.gerenciadordeponto.R;

import java.util.ArrayList;

public class RecyclerViewAdapterVisualizarBatidas extends RecyclerView.Adapter<RecyclerViewAdapterVisualizarBatidas.ViewHolder> {
    private ArrayList<String> listaPontos;

    public RecyclerViewAdapterVisualizarBatidas(Context context, ArrayList<String> listaPontos) {
        this.listaPontos = listaPontos;
        this.context = context;
    }

    private Context context;

    @Override
    public RecyclerViewAdapterVisualizarBatidas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view_batidas, parent, false);
        RecyclerViewAdapterVisualizarBatidas.ViewHolder holder = new RecyclerViewAdapterVisualizarBatidas.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textoItem.setText(listaPontos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPontos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textoItem;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textoItem = itemView.findViewById(R.id.textoItem);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
