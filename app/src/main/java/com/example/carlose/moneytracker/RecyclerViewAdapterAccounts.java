package com.example.carlose.moneytracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterAccounts extends RecyclerView.Adapter<RecyclerViewAdapterAccounts.ViewHolderAccount> {

    List<Account> accountList;
    Context context;

    public RecyclerViewAdapterAccounts(Context context, List<Account> accountList){
        this.context = context;
        this.accountList = accountList;
    }

    @NonNull
    @Override
    public ViewHolderAccount onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.account_cardview_fragment, viewGroup, false);

        return new ViewHolderAccount(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAccount viewHolder, int i) {
        Account account = this.accountList.get(i);
        viewHolder.accountCardTitle.setText(account.getAccountName());
        viewHolder.balanceLabelFragment.setText(account.getAmountString());
        viewHolder.typeLabelFragment.setText(account.getType());
    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }

    public class ViewHolderAccount extends RecyclerView.ViewHolder{

        TextView accountCardTitle;
        TextView balanceLabelFragment;
        TextView typeLabelFragment;

        public ViewHolderAccount(@NonNull View itemView) {
            super(itemView);

            this.accountCardTitle = itemView.findViewById(R.id.accountCardTitle);
            this.balanceLabelFragment = itemView.findViewById(R.id.balanceLabelFragment);
            this.typeLabelFragment = itemView.findViewById(R.id.typeLabelFragment);
        }
    }
}
