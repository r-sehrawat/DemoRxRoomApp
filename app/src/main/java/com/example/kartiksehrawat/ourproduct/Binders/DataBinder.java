package com.example.kartiksehrawat.ourproduct.Binders;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.kartiksehrawat.ourproduct.Adapters.DataBindAdapter;

/**
 * Created by kartiksehrawat on 16/09/17.
 */

abstract public class DataBinder<T extends RecyclerView.ViewHolder> {

    private DataBindAdapter mDataBindAdapter;

    public DataBinder(DataBindAdapter dataBindAdapter) {
        mDataBindAdapter = dataBindAdapter;
    }

    abstract public T newViewHolder(ViewGroup parent);

    abstract public void bindViewHolder(T holder, int position);


    public final void notifyDataSetChanged() {
        mDataBindAdapter.notifyDataSetChanged();
    }

}

