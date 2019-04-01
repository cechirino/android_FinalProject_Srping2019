package com.example.carlose.moneytracker;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Budget> budgetsList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Budget> budgetsList){
        this.budgetsList = budgetsList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View  view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.budget_cardview_fragment, viewGroup, false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            Budget budget =  budgetsList.get(i);
            viewHolder.budgetCardTitle.setText(budget.getBudgetName());
            viewHolder.moneySavedLabelBudgetFragment.setText(budget.getAmountString());
            viewHolder.goalLabelBudgetFragment.setText(budget.getGoalString());
    }

    @Override
    public int getItemCount() {
        return budgetsList.size();
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
