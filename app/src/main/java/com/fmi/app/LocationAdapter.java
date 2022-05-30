package com.fmi.app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private ArrayList<LocationModal> locationModalArrayList;
    private OnNoteListener onNoteListener;

    public LocationAdapter(ArrayList<LocationModal> locationModalArrayList, Context context, OnNoteListener onNoteListener) {
        this.locationModalArrayList = locationModalArrayList;
        this.onNoteListener = onNoteListener;
    }

    public void filterList(ArrayList<LocationModal> filterlist) {
        locationModalArrayList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_rv_item, parent, false);
        return new ViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position) {
        LocationModal modal = locationModalArrayList.get(position);
        holder.locationNameTV.setText(modal.getLocationName());
        holder.locationDescTV.setText(modal.getLocationDescription());
    }

    @Override
    public int getItemCount() {
        return locationModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView locationNameTV, locationDescTV;
        OnNoteListener onNoteListener;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            locationNameTV = itemView.findViewById(R.id.idTVLocationName);
            locationDescTV = itemView.findViewById(R.id.idTVLocationDescription);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }


    }
    public interface  OnNoteListener {
        void onNoteClick(int position);
    }

}
