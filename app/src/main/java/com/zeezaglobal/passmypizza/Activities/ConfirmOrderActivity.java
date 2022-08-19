package com.zeezaglobal.passmypizza.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zeezaglobal.passmypizza.Database.AppDatabase;
import com.zeezaglobal.passmypizza.R;
import com.zeezaglobal.passmypizza.Utils.Constants;

public class ConfirmOrderActivity extends AppCompatActivity {
private TextView price,crust,size,topings;
private Button MakeOrderBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        initComponents();

        price.setText("$ "+Constants.ACTIVE_PIZZA.getPrice()+"");
        crust.setText(Constants.ACTIVE_PIZZA.getCrust());
        size.setText(Constants.ACTIVE_PIZZA.getSize());
        topings.setText(Constants.ACTIVE_PIZZA.getTopings());
        MakeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase appDatabase=AppDatabase.getDatabase(ConfirmOrderActivity.this);
                appDatabase.pizzaDao().insert(Constants.ACTIVE_PIZZA);
              startActivity(new Intent(ConfirmOrderActivity.this,HomeActivity.class));
              finish();
            }
        });
    }

    private void initComponents() {

        price=findViewById(R.id.price);
        crust=findViewById(R.id.crust_tv);
        size=findViewById(R.id.size_tv);
        topings=findViewById(R.id.topings_tv);
        MakeOrderBtn=findViewById(R.id.make_order_btn);
    }
}