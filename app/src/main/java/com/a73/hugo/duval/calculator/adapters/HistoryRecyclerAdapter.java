package com.a73.hugo.duval.calculator.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a73.hugo.duval.calculator.R;
import com.a73.hugo.duval.calculator.model.Calculation;
import com.a73.hugo.duval.calculator.model.HistorySingleton;

import java.util.ArrayList;

public class HistoryRecyclerAdapter  extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHandler> {

    @NonNull
    @Override
    public HistoryRecyclerAdapter.ViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        ViewHandler vh = new ViewHandler(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecyclerAdapter.ViewHandler holder, int position) {
        holder.bindItem(HistorySingleton.getInstance().getCalculations().get(position));
    }

    @Override
    public int getItemCount() {
        return HistorySingleton.getInstance().getCalculations().size();
    }

    static class ViewHandler extends RecyclerView.ViewHolder {
        TextView calculation;
        TextView result;
        View v;

        ViewHandler(View v) {
            super(v);
            calculation = v.findViewById(R.id.calculation);
            result = v.findViewById(R.id.result);
            this.v = v;
        }

        public void bindItem(final Calculation calcul) {
            calculation.setText(calcul.getFirstValue() + " " + calcul.getOperationLabel() + " " + calcul.getSecondValue());
            result.setText(calcul.processCalculation().toString());
        }
    }
}
