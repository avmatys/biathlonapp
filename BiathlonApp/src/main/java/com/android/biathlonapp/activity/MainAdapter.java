package com.android.biathlonapp.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.biathlonapp.R;
import com.android.biathlonapp.race.BiathlonRace;
import com.android.biathlonapp.race.Race;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Race> biathlonRacesList;

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        public TextView dateTextView;
        public TextView raceTypeTextView;
        public TextView genderTextView;
        public TextView distanceTextView;
        public TextView descriptionTextView;

        public MainViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date);
            raceTypeTextView = itemView.findViewById(R.id.race_type);
            genderTextView = itemView.findViewById(R.id.gender);
            distanceTextView = itemView.findViewById(R.id.distance);
            descriptionTextView = itemView.findViewById(R.id.description);
        }
    }

    public MainAdapter(List<Race> biathlonRacesList) {
        this.biathlonRacesList = biathlonRacesList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.biathlon_race_item, parent, false);
        return new MainViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        BiathlonRace race = (BiathlonRace) biathlonRacesList.get(position);
        // Date
        TextView dateTextView = holder.dateTextView;
        dateTextView.setText(race.getDate().toString());
        // Race type
        TextView raceTypeTextView = holder.raceTypeTextView;
        raceTypeTextView.setText(race.getRaceType());
        // Gender
        TextView genderTextView = holder.genderTextView;
        genderTextView.setText(race.getGender());
        // Distance
        TextView distanceTextView = holder.distanceTextView;
        distanceTextView.setText(String.valueOf(race.getDistance()));
        // Description
        TextView descriptionTextView = holder.descriptionTextView;
        descriptionTextView.setText(race.getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return biathlonRacesList.size();
    }
}
