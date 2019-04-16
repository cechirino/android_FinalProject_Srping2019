package com.example.carlose.moneytracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterExpenses extends RecyclerView.Adapter<RecyclerViewAdapterExpenses.ViewHolderExpenses> {

    List<Expenses> expensesList;
    Context context;

    public RecyclerViewAdapterExpenses(Context context,List<Expenses> expensesList){
        this.context = context;
        this.expensesList = expensesList;
    }

    @NonNull
    @Override
    public ViewHolderExpenses onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expenses_cardview_fragment, viewGroup, false);
        return new ViewHolderExpenses(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderExpenses viewHolder, int i) {
        Expenses expenses = expensesList.get(i);
        viewHolder.dueDateLabelFragment.setText(expenses.getDueDate());
        viewHolder.moneyToSpendFragment.setText(expenses.getAmount().toString());
        viewHolder.expensesCardTitle.setText(expenses.getExpenseName());
    }

    @Override
    public int getItemCount() {
        return expensesList.size();
    }

    public class ViewHolderExpenses extends RecyclerView.ViewHolder{
        TextView dueDateLabelFragment;
        TextView moneyToSpendFragment;
        TextView expensesCardTitle;

        public ViewHolderExpenses(@NonNull View itemView) {
            super(itemView);

            this.dueDateLabelFragment = itemView.findViewById(R.id.dueDateLabelFragment);
            this.moneyToSpendFragment = itemView.findViewById(R.id.moneyToSpendFragment);
            this.expensesCardTitle = itemView.findViewById(R.id.expensesCardTitle);
        }
    }
}
