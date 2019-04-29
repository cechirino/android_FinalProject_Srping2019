package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class EditAccountsActivity extends AppCompatActivity {
    private MasterClass masterClass;
    private Account account;
    TextView txtBoxAccountEditName;
    TextView txtBoxAccountEditAmount;
    Spinner spinnerAccoutnEdit;
    TextView accountMoney;

    Button remove;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoute_edit_accounts);

        this.txtBoxAccountEditName = findViewById(R.id.txtBoxAccoutnEditName);
        this.txtBoxAccountEditAmount = findViewById(R.id.txtBoxAccountEditAmount);
        this.spinnerAccoutnEdit = findViewById(R.id.spinnerAccountEdit);
        this.accountMoney = findViewById(R.id.moneyLabelAccountEdit);
        masterClass = MasterClass.get(this);

        this.account = (Account) getIntent().getSerializableExtra("Account");

        this.txtBoxAccountEditName.setText(account.getAccountName());
        this.txtBoxAccountEditAmount.setText(account.getAmountString());
        this.accountMoney.setText(account.getAmountString());

        this.remove = findViewById(R.id.removeButtonAccount);
        this.save = findViewById(R.id.saveButtonAccount);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAccount();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAccount();
            }
        });

    }

    private  void removeAccount(){
        masterClass.delete(account);

        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    private void saveAccount(){
        this.account.setAccountName(this.txtBoxAccountEditName.getText().toString());
        this.account.setAmount(Double.parseDouble(this.txtBoxAccountEditAmount.getText().toString()));
        this.account.setType(this.spinnerAccoutnEdit.getSelectedItem().toString());

        masterClass.update(account);

        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
}
