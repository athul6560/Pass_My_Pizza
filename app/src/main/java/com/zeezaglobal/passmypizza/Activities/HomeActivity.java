package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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

public class HomeActivity extends AppCompatActivity  implements PizzaBlockAdapter.ItemClickListener {
  private  PizzaBlockAdapter adapter;
   private List<Pizza> pizzaList=new ArrayList<>();
    String baseString;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pizza_one);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteStream);
        byte[] byteArray = byteStream.toByteArray();
        baseString = Base64.encodeToString(byteArray,Base64.DEFAULT);
    }

    private void initComponents() {
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
Pizza pizzaOne= new Pizza("Classic Pizza\nWith Canadian Beef",baseString,2.1,2);
pizzaList.add(pizzaOne);
pizzaList.add(pizzaOne);
pizzaList.add(pizzaOne);
        adapter = new PizzaBlockAdapter(this, pizzaList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}