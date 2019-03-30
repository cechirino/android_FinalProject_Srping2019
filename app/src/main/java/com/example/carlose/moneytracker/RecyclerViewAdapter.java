package com.example.carlose.moneytracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView budgetCardTitle;
        TextView moneySavedLabelBudgetFragment;
        TextView goalLabelBudgetFragment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.budgetCardTitle = itemView.findViewById(R.id.budgetCardTitle);
            this.moneySavedLabelBudgetFragment = itemView.findViewById(R.id.moneySavedLabelBudgetFragment);
            this.goalLabelBudgetFragment = itemView.findViewById(R.id.goalLabelBudgetFragment);
        }
    }
}
