package com.example.earthquake.fg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.earthquake.Earthquake;
import com.example.earthquake.R;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment {

    private final List<Earthquake> mEarthquakes = new ArrayList<>();
    private final EarthquakeRecyclerViewAdapter mEarthquakeRecyclerViewAdapter = new EarthquakeRecyclerViewAdapter(mEarthquakes);
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mEarthquakeRecyclerViewAdapter);
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        for (Earthquake earthquake : earthquakes) {
            if (!mEarthquakes.contains(earthquake)) {
                mEarthquakes.add(earthquake);
                mEarthquakeRecyclerViewAdapter.notifyItemInserted(mEarthquakes.indexOf(earthquake));
            }
        }
    }
}
