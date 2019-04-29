package com.example.carlose.moneytracker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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
    public void onBindViewHolder(@NonNull final ViewHolderExpenses viewHolder, int i) {
       final Expenses expenses = expensesList.get(i);
        viewHolder.dueDateLabelFragment.setText(expenses.getDueDate());
        viewHolder.moneyToSpendFragment.setText(expenses.getAmount().toString());
        viewHolder.expensesCardTitle.setText(expenses.getExpenseName());

        viewHolder.expensesCardViewFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.expensesCardViewFragment.getContext(), EditExpensesActivity.class);
                intent.putExtra("Expenses", expenses);
                viewHolder.expensesCardViewFragment.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return expensesList.size();
    }

    public class ViewHolderExpenses extends RecyclerView.ViewHolder{
        TextView dueDateLabelFragment;
        TextView moneyToSpendFragment;
        TextView expensesCardTitle;
        CardView expensesCardViewFragment;

        public ViewHolderExpenses(@NonNull View itemView) {
            super(itemView);

            this.dueDateLabelFragment = itemView.findViewById(R.id.dueDateLabelFragment);
            this.moneyToSpendFragment = itemView.findViewById(R.id.moneyToSpendFragment);
            this.expensesCardTitle = itemView.findViewById(R.id.expensesCardTitle);
            this.expensesCardViewFragment = itemView.findViewById(R.id.expensesCardViewFragment);
        }
    }
}
