package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class ReceiptActivity extends AppCompatActivity {
    private CardView recieptsCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_receipts);

        recieptsCardView = (CardView) findViewById(R.id.receiptsCardViewR);
        recieptsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallEditReceiptActivity();
            }
        });
    }

    private void CallEditReceiptActivity(){
        Intent intent = new Intent(this, EditReceiptActivity.class);
        startActivity(intent);
    }
}
