package com.gufran.quickreturnfloaterapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Description ...
 *
 * @author Gufran Khurshid
 * @version 1.0
 * @since 5/15/17
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ItemHolder> {
    private LayoutInflater layoutInflater;
    ArrayList<String> dataList;

    public SimpleAdapter(Context context, ArrayList<String> dataList) {
        layoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
    }

    @Override
    public SimpleAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.layout_item, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SimpleAdapter.ItemHolder holder, int position) {
        holder.textItemName.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView textItemName;

        public ItemHolder(View itemView) {
            super(itemView);
            textItemName = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
