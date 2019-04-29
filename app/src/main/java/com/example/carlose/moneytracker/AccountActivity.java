package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    private CardView accountListCardView;
    private Button addButton;
    private MasterClass masterClass;
    private EditText accountNameTxtBox;
    private EditText amountAccountTxtBox;
    private Spinner spinnerAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_account);

       masterClass = MasterClass.get(AccountActivity.this);
        accountListCardView = (CardView) findViewById(R.id.accountCardViewEmpty);
        accountNameTxtBox = findViewById(R.id.accountNameTxtBox);
        amountAccountTxtBox = findViewById(R.id.amountAccountTxtBox);
        spinnerAccount = findViewById(R.id.spinnerAccount);

       if (masterClass.getAccount().size() > 0) {

            accountListCardView.setVisibility(View.GONE);
            initRecyclerViewAccounts();
        } else {
            RecyclerView viewRecyclerView = findViewById(R.id.accountRecyclerView);
            viewRecyclerView.setVisibility(View.GONE);
            accountListCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AccountActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                }
            });
        }

        addButton = findViewById(R.id.addButtonAccount);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!accountNameTxtBox.getText().toString().equals("") && !amountAccountTxtBox.getText().toString().equals("")){

                    Account account = new Account(accountNameTxtBox.getText().toString(),spinnerAccount.getSelectedItem().toString()
                            , Double.parseDouble(amountAccountTxtBox.getText().toString()));

                    masterClass.addData(account);
                    initRecyclerViewAccounts();
                    accountNameTxtBox.setText("");
                    amountAccountTxtBox.setText("");
                    refreshActivity();
                }
                else{
                    Toast.makeText(AccountActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });

     }

    public void initRecyclerViewAccounts(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.accountRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterAccounts adapter = new RecyclerViewAdapterAccounts(this, masterClass.getAccount());
        recyclerView.setAdapter(adapter);

    }

    private void refreshActivity(){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    @Override
    public  void onBackPressed(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
