package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;

import com.zeezaglobal.passmypizza.Adapters.PizzaBlockAdapter;
import com.zeezaglobal.passmypizza.Data.Pizza;
import com.zeezaglobal.passmypizza.Database.AppDatabase;
import com.zeezaglobal.passmypizza.R;
import com.zeezaglobal.passmypizza.Utils.Constants;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements PizzaBlockAdapter.ItemClickListener {
    private PizzaBlockAdapter adapter;
    private EditText searchEt;
    private List<Pizza> listData;
   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();


        onClicks();

        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<Pizza> newList = new ArrayList<>();
                for (int j = 0; j < listData.size(); j++) {
                    if (listData.get(j).getPizzaName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        newList.add(listData.get(j));
                    }
                }
                setAdapterRV(newList);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void onClicks() {
        findViewById(R.id.create_pizza).setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this, PizzaBuildPage.class));
        });
    }

    private void initComponents() {
        searchEt = findViewById(R.id.search_edittext);
        // set up the RecyclerView
        AppDatabase appDatabase = AppDatabase.getDatabase(HomeActivity.this);

         recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listData = appDatabase.pizzaDao().getAll();
        setAdapterRV(listData);

    }

    private void setAdapterRV(List<Pizza> listData) {
        adapter = new PizzaBlockAdapter(this, listData);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}