package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class ExpensesActivity extends AppCompatActivity {
    private CardView expenseslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_expenses);

        expenseslist = (CardView) findViewById(R.id.expensesCardViewE);
        expenseslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallEditExpensesActivity();
            }
        });
    }

    private  void CallEditExpensesActivity(){
        Intent intent = new Intent(this, EditExpensesActivity.class);
        startActivity(intent);
    }
}
