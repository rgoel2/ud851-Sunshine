package com.example.android.sunshine;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by rohangoel on 6/25/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;

    ForecastAdapter() {

    }


    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context= viewGroup.getContext();
        int layoutIdForListItem=R.layout.forecast_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately= false;

        View view=inflater.inflate(layoutIdForListItem,viewGroup,shouldAttachToParentImmediately);
                return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        String weatherData=mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherData);
    }

    @Override
    public int getItemCount() {
        if(mWeatherData==null) return 0;
         return mWeatherData.length;
    }
    public void setWeatherData(String[] weatherData)
    {
        mWeatherData=weatherData;
        notifyDataSetChanged();
    }
}

