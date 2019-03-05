package com.example.carlose.moneytracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button menu;
    private CardView expensesCardView;
    private CardView budgetCardview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (Button) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallActivity();
            }
        });

        expensesCardView = (CardView) findViewById(R.id.expensesCardView);

        expensesCardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expensesCardView.getContext().startActivity(new Intent(expensesCardView.getContext(), EditExpensesActivity.class));
            }
        });
    }

    private void CallExpensesEditLayout()
    {
        Intent intent = new Intent(getApplicationContext(), EditExpensesActivity.class);
        startActivity(intent);
    }

    private void CallActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
