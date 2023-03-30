package com.example.earthquake.fg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.earthquake.Earthquake;
import com.example.earthquake.R;

import java.util.List;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {
    private final List<Earthquake> mEarthquakes;

    public EarthquakeRecyclerViewAdapter(List<Earthquake> earthquakes) {
        mEarthquakes = earthquakes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_earthquake, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mEarthquake = mEarthquakes.get(position);
        holder.mDetailsView.setText(holder.mEarthquake.toString());
    }

    @Override
    public int getItemCount() {
        return mEarthquakes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final View mParentView;
        public final TextView mDetailsView;
        public Earthquake mEarthquake;

        public ViewHolder(@NonNull View view) {
            super(view);
            mParentView = view;
            mDetailsView = view.findViewById(R.id.list_item_earthquake_details);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDetailsView.getText() + "'";
        }
    }
}
