package com.example.emploi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emploi.R;
import com.example.emploi.entities.Meeting;

import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MyViewHolder> {
    private List<Meeting> meetingsList;
    private LayoutInflater inflater;

    public MeetingAdapter(Context context, List<Meeting> meetingsList) {
        this.inflater = LayoutInflater.from(context);
        this.meetingsList = meetingsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_meeting, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Meeting meeting = meetingsList.get(position);

        // Concaténez " heures" à la durée du meeting
        String dureeAvecHeures = meeting.getMeetDuree() + " heures";

        holder._id_txt.setText(String.valueOf(meeting.getIdMeet()));
        holder.meet_title_txt.setText(meeting.getMeetTitle());
        holder.meet_date_txt.setText(meeting.getMeetDate());
        holder.meet_duree_txt.setText(dureeAvecHeures);
        holder.meet_salle_txt.setText(meeting.getMeetSalle());
        holder.meet_link_txt.setText(meeting.getMeetLink());
    }

    @Override
    public int getItemCount() {
        return meetingsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView _id_txt, meet_title_txt, meet_date_txt, meet_duree_txt, meet_salle_txt, meet_link_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            _id_txt = itemView.findViewById(R.id._id_txt);
            meet_title_txt = itemView.findViewById(R.id.meet_title_txt);
            meet_date_txt = itemView.findViewById(R.id.meet_date_txt);
            meet_duree_txt = itemView.findViewById(R.id.meet_duree_txt);
            meet_salle_txt = itemView.findViewById(R.id.meet_salle_txt);
            meet_link_txt = itemView.findViewById(R.id.meet_link_txt);
        }
    }
}
