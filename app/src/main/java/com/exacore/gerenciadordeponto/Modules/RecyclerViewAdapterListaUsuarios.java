package com.exacore.gerenciadordeponto.Modules;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.exacore.gerenciadordeponto.Models.Usuario;
import com.exacore.gerenciadordeponto.R;
import com.exacore.gerenciadordeponto.Views.TelaMsgSucesso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

public class RecyclerViewAdapterListaUsuarios  extends RecyclerView.Adapter<RecyclerViewAdapterListaUsuarios.ViewHolder> {
    private List<Usuario> usuarios;
    private static final String TAG = "RVListaUsuarios";
    private Context context;

    public RecyclerViewAdapterListaUsuarios(Context context, List<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.context = context;
    }


    @Override
    public RecyclerViewAdapterListaUsuarios.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view_lista_usuarios, parent, false);
        RecyclerViewAdapterListaUsuarios.ViewHolder holder = new RecyclerViewAdapterListaUsuarios.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterListaUsuarios.ViewHolder holder, final int position) {
        holder.itemBotao.setText(usuarios.get(position).getNome());
        final String horaAgora = (new SimpleDateFormat("dd/MM/yyyy 'as' hh:mm a", Locale.getDefault()).format(Calendar.getInstance().getTime())).toLowerCase();
        holder.itemBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + usuarios.get(position).getNome());

                Intent intent = new Intent(context, TelaMsgSucesso.class);
                intent.putExtra("principal", "Batida registrada com sucesso!");
                intent.putExtra("secundario", horaAgora);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button itemBotao;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            itemBotao = itemView.findViewById(R.id.itemBotao);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
