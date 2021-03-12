package com.example.interfaceadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ListViewHolder> {
    Context context;
    private List<model> models;
    Interfaces interfaces;

    public adapter(List<model> models, Interfaces interfaces) {
        this.models = models;
        this.interfaces = interfaces;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        adapter.ListViewHolder holder = new adapter.ListViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final model data = models.get(position);
        holder.data.setText(data.getData());
        holder.tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.valueOf(holder.angka.getText().toString());
                x++;
                holder.angka.setText(x+"");
                interfaces.onUpdateTotal(""+x);
            }
        });
        holder.kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.valueOf(holder.angka.getText().toString());
                x--;
                holder.angka.setText(x+"");
                interfaces.onUpdateTotal(""+x);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tambah, kurang, data, angka;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tambah = itemView.findViewById(R.id.tambah);
            kurang = itemView.findViewById(R.id.kurang);
            data = itemView.findViewById(R.id.data);
            angka = itemView.findViewById(R.id.angka);
        }
    }
}
