package com.lambton.c0778923_w2020_mad3125_midterm.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.c0778923_w2020_mad3125_midterm.models.CRACustomer;
import com.lambton.c0778923_w2020_mad3125_midterm.models.DetailList;
import com.lambton.c0778923_w2020_mad3125_midterm.R;
import com.lambton.c0778923_w2020_mad3125_midterm.utilities.Calculator;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

        private ArrayList<DetailList> detailListArrayList;
        CRACustomer craCustomer;

        public DetailAdapter(ArrayList<DetailList> detailListArrayList)
        {
            this.detailListArrayList = detailListArrayList;
        }

        @NonNull
        @Override
        public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View detailItem= layoutInflater.inflate(R.layout.item_detail, parent, false);
            DetailViewHolder detailViewHolder = new DetailViewHolder(detailItem);
            return detailViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final DetailViewHolder holder, final int position) {

            DetailList detailList = this.detailListArrayList.get(position);
                holder.txtName.setText(detailList.getName());
                if (detailList.getName().toLowerCase().equalsIgnoreCase("Carry forward RRSP")) {
                    double parseDouble = Double.parseDouble(detailList.getValue());
                    if (parseDouble < 0.0d) {
                        holder.txtValue.setText(Calculator.getFormattedCurrency(parseDouble));
                        holder.txtValue.setTextColor(Color.RED);
                    }
                    else
                    {
                        holder.txtValue.setText(Calculator.getFormattedCurrency(parseDouble));
                    }
                }
                else
                {
                    holder.txtValue.setText((detailList.getValue()));
                }
            }


        @Override
        public int getItemCount() {
            return this.detailListArrayList.size();
        }

        public class DetailViewHolder extends RecyclerView.ViewHolder  {

            public TextView txtName;
            public TextView txtValue;

            public DetailViewHolder(@NonNull View itemView) {
                super(itemView);

                this.txtName = (TextView) itemView.findViewById(R.id.txtName);
                this.txtValue = (TextView) itemView.findViewById(R.id.txtValue);

            }
        }
    }

