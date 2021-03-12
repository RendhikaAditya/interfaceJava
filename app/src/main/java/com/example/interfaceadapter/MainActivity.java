package com.example.interfaceadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Interfaces{
    RecyclerView rv_produk;
    private List<model> produk;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_produk = findViewById(R.id.rv);
        total = findViewById(R.id.total);

        rv_produk = findViewById(R.id.rv);
        rv_produk.setHasFixedSize(true);
        rv_produk.setLayoutManager(new LinearLayoutManager(this));

        produk = new ArrayList<>();

        produk.add(new model("data 1"));

        adapter adapters = new adapter(produk, this);
        rv_produk.setAdapter(adapters);
        adapters.notifyDataSetChanged();

    }

    @Override
    public void onUpdateTotal(String tot) {
        total.setText(tot);
    }
}