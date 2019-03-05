package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class AccountActivity extends AppCompatActivity {
    private CardView accountListCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_account);

        accountListCardView = (CardView) findViewById(R.id.accountsCardViewA);
        accountListCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallEditAccountActivity();
            }
        });
     }

     private void CallEditAccountActivity(){
         Intent intent = new Intent(this, EditAccountsActivity.class);
         startActivity(intent);
     }
}
