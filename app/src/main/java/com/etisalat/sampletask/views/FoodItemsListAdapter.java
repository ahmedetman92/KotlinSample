package com.etisalat.sampletask.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Etman on 4/26/2018.
 */

public class FoodItemsListAdapter extends
        RecyclerView.Adapter<FoodItemsListAdapter.CustomViewHolder> {


    private List<Item> mFoodList;

    public FoodItemsListAdapter(List<Item> foodList) {
        this.mFoodList = foodList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_row_layout, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindItem(mFoodList.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_item_name, tv_item_desc;
        View v_separator;

        public CustomViewHolder(View view) {
            super(view);
            this.tv_item_name = view.findViewById(R.id.tv_item_name);
            this.tv_item_desc = view.findViewById(R.id.tv_item_desc);
            this.v_separator = view.findViewById(R.id.item_separator);
        }

        void bindItem(Item item) {
            tv_item_name.setText(item.getName());
            tv_item_desc.setText(item.getDescription());
        }
    }
}
