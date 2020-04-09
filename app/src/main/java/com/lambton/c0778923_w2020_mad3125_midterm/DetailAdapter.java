package com.lambton.c0778923_w2020_mad3125_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

        private ArrayList<DetailList> detailListArrayList;

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
            holder.txtValue.setText(detailList.getValue());

            /*holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DetailList dl = detailListArrayList.get(position);
                    Intent intent = new Intent(holder.itemView.getContext(), AttractionDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("attractionsKey", ca);
                    intent.putExtras(bundle);
                    holder.itemView.getContext().startActivity(intent);

                }
            });*/

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

                this.txtName = (TextView) itemView.findViewById(R.id.txtKey);
                this.txtValue = (TextView) itemView.findViewById(R.id.txtValue);

            }
        }
    }

