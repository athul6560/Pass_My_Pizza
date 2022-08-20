package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zeezaglobal.passmypizza.Data.Pizza;
import com.zeezaglobal.passmypizza.R;
import com.zeezaglobal.passmypizza.Utils.Constants;

public class PizzaBuildPage extends AppCompatActivity {
    private Button small, medium, large;
    private Button thinBtn, thickBtn;
    private ImageView thinCrust, thickCrust;
    private ImageView tomatoImg, oliveImg, pestoImg, chieknImg, onionImg;
    private CheckBox tomato, pesto, chiekn, olive, onions;
    private Pizza pizza;
    private String size = "Large", crust = "Thick";
    private StringBuilder topings= new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_build_page);
        initComponents();

        onClicks();

        checkBoxListner();

    }

    private void checkBoxListner() {

        tomato.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tomatoImg.setVisibility(View.VISIBLE);
                    topings.append("Tomato Sauce, ");
                } else {
                    tomatoImg.setVisibility(View.GONE);
                }

            }
        });
        pesto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    pestoImg.setVisibility(View.VISIBLE);
                    topings.append("Pesto Sauce, ");
                } else {
                    pestoImg.setVisibility(View.GONE);
                }

            }
        });
        olive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    oliveImg.setVisibility(View.VISIBLE);
                    topings.append("Olives, ");
                } else {
                    oliveImg.setVisibility(View.GONE);
                }

            }
        });
        chiekn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    chieknImg.setVisibility(View.VISIBLE);
                    topings.append("Chicken, ");
                } else {
                    chieknImg.setVisibility(View.GONE);
                }

            }
        });
        onions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    onionImg.setVisibility(View.VISIBLE);
                    topings.append("Onions, ");
                } else {
                    onionImg.setVisibility(View.GONE);
                }

            }
        });
    }

    private void onClicks() {
        findViewById(R.id.next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){
                pizza=new Pizza(crust+" Crust "+size+" Pizza with "+topings,topings.toString(),size,crust,15.67);


                Constants.ACTIVE_PIZZA = pizza;
                startActivity(new Intent(PizzaBuildPage.this, ConfirmOrderActivity.class));}else{
                    Toast.makeText(PizzaBuildPage.this, "Please select atleast one toping", Toast.LENGTH_SHORT).show();
                }
            }
        });


        thinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crust = "Thin";
                thinCrust.setVisibility(View.VISIBLE);
                thickCrust.setVisibility(View.INVISIBLE);
                thinBtn.setBackgroundResource(R.drawable.round_bg_active);
                thickBtn.setBackgroundResource(R.drawable.round_btn);
            }
        });
        thickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crust = "Thick";
                thickCrust.setVisibility(View.VISIBLE);
                thinCrust.setVisibility(View.INVISIBLE);
                thickBtn.setBackgroundResource(R.drawable.round_bg_active);
                thinBtn.setBackgroundResource(R.drawable.round_btn);
            }
        });
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size = "Small";
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
                size = "Medium";
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
                size = "Large";
                large.setBackgroundResource(R.drawable.round_bg_active);
                medium.setBackgroundResource(R.drawable.round_btn);
                small.setBackgroundResource(R.drawable.round_btn);
                medium.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                small.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.light_grey));
                large.setTextColor(ContextCompat.getColor(PizzaBuildPage.this, R.color.white));
            }
        });
    }

    private boolean validation() {

      if(tomato.isChecked() || pesto.isChecked() || chiekn.isChecked()|| olive.isChecked()|| onions.isChecked()){
          return true;
      }else{
          return false;
      }
    }

    private void initComponents() {
        small = findViewById(R.id.small_size);
        medium = findViewById(R.id.medium_size);
        large = findViewById(R.id.large_size);
        thickBtn = findViewById(R.id.thick);
        thinBtn = findViewById(R.id.thin);
        thinCrust = findViewById(R.id.thin_img);
        thickCrust = findViewById(R.id.thick_img);


        tomato = findViewById(R.id.tomato_sause_ch);
        pesto = findViewById(R.id.pesto_ch);
        chiekn = findViewById(R.id.chiekn_ch);
        olive = findViewById(R.id.olive_ch);
        onions = findViewById(R.id.onion_ch);


        tomatoImg = findViewById(R.id.ketchup);
        pestoImg = findViewById(R.id.pesto);
        chieknImg = findViewById(R.id.chiken);
        oliveImg = findViewById(R.id.olive);
        onionImg = findViewById(R.id.onions);

    }
}