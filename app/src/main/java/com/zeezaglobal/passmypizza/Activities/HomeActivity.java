package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;

import com.zeezaglobal.passmypizza.Adapters.PizzaBlockAdapter;
import com.zeezaglobal.passmypizza.Data.Pizza;
import com.zeezaglobal.passmypizza.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PizzaBlockAdapter.ItemClickListener {
    private PizzaBlockAdapter adapter;
    private List<Pizza> pizzaList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();


        onClicks();
    }

    private void onClicks() {
        findViewById(R.id.create_pizza).setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,PizzaBuildPage.class));
        });
    }

    private void initComponents() {
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PizzaBlockAdapter(this, pizzaList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}