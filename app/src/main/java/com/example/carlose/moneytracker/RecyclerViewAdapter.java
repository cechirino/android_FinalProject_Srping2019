package com.example.carlose.moneytracker;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Budget> budgetsList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Budget> budgetsList){
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

            final Budget budget =  budgetsList.get(i);
            viewHolder.budgetCardTitle.setText(budget.getBudgetName());
            viewHolder.moneySavedLabelBudgetFragment.setText(budget.getAmountString());
            viewHolder.goalLabelBudgetFragment.setText(budget.getGoalString());

            viewHolder.budgetCardViewFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(viewHolder.budgetCardViewFragment.getContext(), EditBudgetActivity.class);
                    intent.putExtra("Budget", budget);
                    context.startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return budgetsList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView budgetCardTitle;
        TextView moneySavedLabelBudgetFragment;
        TextView goalLabelBudgetFragment;
        CardView budgetCardViewFragment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.budgetCardTitle = itemView.findViewById(R.id.budgetCardTitle);
            this.moneySavedLabelBudgetFragment = itemView.findViewById(R.id.moneySavedLabelBudgetFragment);
            this.goalLabelBudgetFragment = itemView.findViewById(R.id.goalLabelBudgetFragment);
            this.budgetCardViewFragment = itemView.findViewById(R.id.budgetCardViewFragment);
        }
    }
}
