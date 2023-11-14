package com.example.emploi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emploi.R;
import com.example.emploi.UpdateMeetingActivity;
import com.example.emploi.entities.Meeting;

import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MyViewHolder> {
    private List<Meeting> meetingsList;
    private LayoutInflater inflater;
    int position;
    private Context context;

    Activity activity;

    public MeetingAdapter(Activity activity, Context context, List<Meeting> meetingsList) {
        this.activity = activity;
        this.inflater = LayoutInflater.from(context);
        this.meetingsList = meetingsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_meeting, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //this.position = position;
        Meeting meeting = meetingsList.get(position);

        // Concaténez " heures" à la durée du meeting
        String dureeAvecHeures = meeting.getMeetDuree() + " heures";

        holder._id_txt.setText(String.valueOf(meeting.getIdMeet()));
        holder.meet_title_txt.setText(meeting.getMeetTitle());
        holder.meet_date_txt.setText(meeting.getMeetDate());
        holder.meet_duree_txt.setText(dureeAvecHeures);
        holder.meet_salle_txt.setText(meeting.getMeetSalle());
        holder.meet_link_txt.setText(meeting.getMeetLink());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateMeetingActivity.class);
                intent.putExtra("meet_id", String.valueOf(meeting.getIdMeet()));
                intent.putExtra("meet_title", meeting.getMeetTitle());
                intent.putExtra("meet_link", meeting.getMeetLink());
                intent.putExtra("meet_date", meeting.getMeetDate());
                intent.putExtra("meet_salle", meeting.getMeetSalle());
                intent.putExtra("meet_duree", String.valueOf(meeting.getMeetDuree()));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meetingsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView _id_txt, meet_title_txt, meet_date_txt, meet_duree_txt, meet_salle_txt, meet_link_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            _id_txt = itemView.findViewById(R.id._id_txt);
            meet_title_txt = itemView.findViewById(R.id.meet_title_txt);
            meet_date_txt = itemView.findViewById(R.id.meet_date_txt);
            meet_duree_txt = itemView.findViewById(R.id.meet_duree_txt);
            meet_salle_txt = itemView.findViewById(R.id.meet_salle_txt);
            meet_link_txt = itemView.findViewById(R.id.meet_link_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
