package com.example.carlose.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EditAccountsActivity extends AppCompatActivity {
    private MasterClass masterClass;
    private Account account;
    TextView txtBoxAccoutnEditName;
    TextView txtBoxAccountEditAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoute_edit_accounts);

        this.txtBoxAccoutnEditName = findViewById(R.id.txtBoxAccoutnEditName);
        this.txtBoxAccountEditAmount = findViewById(R.id.txtBoxAccountEditAmount);
        masterClass = MasterClass.get(this);

        this.account = (Account) getIntent().getSerializableExtra("Account");

        this.txtBoxAccoutnEditName.setText(account.getAccountName());
        this.txtBoxAccountEditAmount.setText(account.getAmountString());

    }
}
