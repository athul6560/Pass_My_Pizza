package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zeezaglobal.passmypizza.R;

public class PizzaBuildPage extends AppCompatActivity {
   private Button small, medium, large;
   private Button thinBtn, thickBtn;
    private ImageView thinCrust, thickCrust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_build_page);
        initComponents();

        onClicks();

    }

    private void onClicks() {
        thinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thinCrust.setVisibility(View.VISIBLE);
                thickCrust.setVisibility(View.INVISIBLE);
                thinBtn.setBackgroundResource(R.drawable.round_bg_active);
                thickBtn.setBackgroundResource(R.drawable.round_btn);
            }
        });
        thickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thickCrust.setVisibility(View.VISIBLE);
                thinCrust.setVisibility(View.INVISIBLE);
                thickBtn.setBackgroundResource(R.drawable.round_bg_active);
                thinBtn.setBackgroundResource(R.drawable.round_btn);
            }
        });
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                small.setBackgroundResource(R.drawable.round_bg_active);
                medium.setBackgroundResource(R.drawable.round_btn);
                large.setBackgroundResource(R.drawable.round_btn);
                medium.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                large.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                small.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.white));
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medium.setBackgroundResource(R.drawable.round_bg_active);
                small.setBackgroundResource(R.drawable.round_btn);
                large.setBackgroundResource(R.drawable.round_btn);
                small.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                large.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                medium.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.white));
            }
        });
        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                large.setBackgroundResource(R.drawable.round_bg_active);
                medium.setBackgroundResource(R.drawable.round_btn);
                small.setBackgroundResource(R.drawable.round_btn);
                medium.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                small.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                large.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.white));
            }
        });
    }

    private void initComponents() {
        small = findViewById(R.id.small_size);
        medium = findViewById(R.id.medium_size);
        large = findViewById(R.id.large_size);
        thickBtn = findViewById(R.id.thick);
        thinBtn = findViewById(R.id.thin);
        thinCrust = findViewById(R.id.thin_img);
        thickCrust = findViewById(R.id.thick_img);
    }
}