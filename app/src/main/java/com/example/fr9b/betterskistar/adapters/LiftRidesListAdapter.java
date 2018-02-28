package com.example.fr9b.betterskistar.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fr9b.betterskistar.databinding.ListItemBinding;
import com.example.fr9b.betterskistar.models.SkistarRideStatistics;

import java.util.List;


class MyViewHolder extends RecyclerView.ViewHolder {
    public ListItemBinding binding;

    public MyViewHolder(View itemView) {
        super(itemView);
        //Store binder reference for view
        binding = DataBindingUtil.bind(itemView);
    }
}

public class LiftRidesListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<SkistarRideStatistics> liftRides;

    public LiftRidesListAdapter(List<SkistarRideStatistics> liftRides) {
        this.liftRides = liftRides;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflate a new view and store in a new Viewholder
        View v = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false).getRoot();

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Assign viewModel to view
        SkistarRideStatistics liftRide = liftRides.get(position);
        holder.binding.setViewModel(liftRide);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return liftRides.size();
    }

    public void setList(List<SkistarRideStatistics> liftRides)
    {
        this.liftRides = liftRides;
        this.notifyDataSetChanged();
    }

}

