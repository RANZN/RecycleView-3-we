package com.ranzan.recycleview3we;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvAddress;
    private OnitemClickListner onitemClickListner;
    private LinearLayout linearLayout;

    public EmployeeViewHolder(@NonNull View itemView, OnitemClickListner onitemClickListner) {
        super(itemView);
        this.onitemClickListner = onitemClickListner;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        linearLayout = itemView.findViewById(R.id.layout);
    }

    public void setData(Employee employee) {
        mTvName.setText(employee.getName());
        mTvAge.setText(employee.getAge() + "");
        mTvAddress.setText(employee.getAddress());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClickListner.onItemClick(employee, getAdapterPosition());
            }
        });

    }
}
