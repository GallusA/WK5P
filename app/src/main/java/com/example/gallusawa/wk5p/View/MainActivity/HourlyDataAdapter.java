package com.example.gallusawa.wk5p.View.MainActivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gallusawa.wk5p.R;
import com.example.gallusawa.wk5p.model.HourlyForecast;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HourlyDataAdapter extends RecyclerView.Adapter<HourlyDataAdapter.ViewHolder>{

    List<HourlyForecast> hourlyForecastList;
    Context c;
    private int lastPosition = -1;
    private String units;

    public HourlyDataAdapter(List<HourlyForecast> hourlyForecastList) {
        this.hourlyForecastList = hourlyForecastList;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHour,tvDegree;
        ImageView ivIcon;
        public ViewHolder(View itemView) {
            super(itemView);
            tvHour = (TextView) itemView.findViewById(R.id.tvHour);
            tvDegree = (TextView) itemView.findViewById(R.id.tvDegree);
            ivIcon = (ImageView) itemView.findViewById(R.id.ivIcon);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        c = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weahter_hourly_list,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HourlyForecast item = hourlyForecastList.get(position);
        holder.tvHour.setText(item.getFCTTIME().getCivil());
        if (units.equals("Celsius"))
            holder.tvDegree.setText(item.getTemp().getMetric() + "°C");
        else
            holder.tvDegree.setText(item.getTemp().getEnglish() + "°F");
        Picasso.with(holder.itemView.getContext()).load(item.getIconUrl()).into(holder.ivIcon);
    }

    @Override
    public int getItemCount() {
        return hourlyForecastList.size();
    }


}
