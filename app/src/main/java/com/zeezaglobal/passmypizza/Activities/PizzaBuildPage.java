package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.zeezaglobal.passmypizza.R;

public class PizzaBuildPage extends AppCompatActivity {
Button small,medium,large;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_build_page);
        initComponents();

        onClicks();
    }

    private void onClicks() {

    }

    private void initComponents() {
        small=findViewById(R.id.small_size);
        medium=findViewById(R.id.medium_size);
        large=findViewById(R.id.large_size);
    }
}