package com.example.gallusawa.wk5p.View.MainActivity;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gallusawa.wk5p.R;
import com.example.gallusawa.wk5p.model.HourlyForecastOrdered;

import java.util.List;


public class OrderedDataAdapter extends RecyclerView.Adapter<OrderedDataAdapter.ViewHolder> {
    List<HourlyForecastOrdered> hourlyForecastOrdered;
    Context c;
    private int lastPosition = -1;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private String unit;

    public OrderedDataAdapter(List<HourlyForecastOrdered> hourlyForecastOrdered) {
        this.hourlyForecastOrdered = hourlyForecastOrdered;
    }

    public void setUnits(String unit) {
        this.unit = unit;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay;
        RecyclerView rvWeather;
        public ViewHolder(View itemView) {
            super(itemView);
            tvDay = (TextView) itemView.findViewById(R.id.tvDay);
            rvWeather = (RecyclerView) itemView.findViewById(R.id.rvWeather);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        c = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HourlyForecastOrdered item = hourlyForecastOrdered.get(position);
        holder.tvDay.setText(item.getLabel());
        layoutManager = new GridLayoutManager(c,4);
        itemAnimator = new DefaultItemAnimator();
        holder.rvWeather.setLayoutManager(layoutManager);
        holder.rvWeather.setItemAnimator(itemAnimator);

        HourlyDataAdapter hourlyDataAdapter = new HourlyDataAdapter(item.getHourlyForecastOrdered());
        holder.rvWeather.setAdapter(hourlyDataAdapter);
        hourlyDataAdapter.setUnits(unit);
        hourlyDataAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return hourlyForecastOrdered.size();
    }



}
