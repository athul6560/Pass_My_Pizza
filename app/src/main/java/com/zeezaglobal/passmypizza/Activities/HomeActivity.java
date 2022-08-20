package com.zeezaglobal.passmypizza.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
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
    // data for the recyclerview
    private List<Pizza> listData;
   private RecyclerView recyclerView;
   private AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();


        onClicks();
// listen the words of the edittext for search function
        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //filter the list using search keyword
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
        appDatabase = AppDatabase.getDatabase(HomeActivity.this);

         recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listData = appDatabase.pizzaDao().getAll();
        setAdapterRV(listData);

    }

    private void setAdapterRV(List<Pizza> listData) {

        adapter = new PizzaBlockAdapter(this, listData);
        adapter.setClickListener(this);
        //used for swipe to delete function
        new ItemTouchHelper(itemTouch).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
// swipe to delete callback function
    ItemTouchHelper.SimpleCallback itemTouch=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            appDatabase.pizzaDao().delete(listData.get(viewHolder.getAdapterPosition()));
            listData.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
        }
    };
}