package com.example.kartiksehrawat.ourproduct.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.kartiksehrawat.ourproduct.Binders.DataBinder;

/**
 * Created by kartiksehrawat on 16/09/17.
 */

public abstract class DataBindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getDataBinder(viewType).newViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        getDataBinder(getItemViewType(position)).bindViewHolder(viewHolder, position);
    }

    @Override
    public abstract int getItemCount();

    @Override
    public abstract int getItemViewType(int position);

    public abstract <T extends DataBinder> T getDataBinder(int viewType);


}