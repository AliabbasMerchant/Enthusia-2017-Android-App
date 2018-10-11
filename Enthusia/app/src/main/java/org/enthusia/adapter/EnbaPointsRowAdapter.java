package org.enthusia.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.model.PointsRow;

import java.util.ArrayList;

public class EnbaPointsRowAdapter extends RecyclerView.Adapter<EnbaPointsRowAdapter.MyViewHolder> {
    private ArrayList<PointsRow> listOfTeams;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sr_no, team_name, p, w, l, pf, pa, pts;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sr_no = itemView.findViewById(R.id.sr_no);
            team_name = itemView.findViewById(R.id.team_name);
            p = itemView.findViewById(R.id.p);
            w = itemView.findViewById(R.id.w);
            l = itemView.findViewById(R.id.l);
            pf = itemView.findViewById(R.id.pf);
            pa = itemView.findViewById(R.id.pa);
            pts = itemView.findViewById(R.id.pts);

        }

    }

    public EnbaPointsRowAdapter(ArrayList<PointsRow> listOfTeams){
        this.listOfTeams = listOfTeams;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.points_row, viewGroup, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MyViewHolder holder = myViewHolder;
        PointsRow row = listOfTeams.get(i);

        holder.team_name.setText(row.getTeam_name());
        holder.sr_no.setText(row.getSr_no());
        holder.p.setText(row.getP());
        holder.w.setText(row.getW());
        holder.l.setText(row.getL());
        holder.pf.setText(row.getPf());
        holder.pa.setText(row.getPa());
        holder.pts.setText(row.getPts());
    }

    @Override
    public int getItemCount() {
        return listOfTeams.size();
    }




 }
