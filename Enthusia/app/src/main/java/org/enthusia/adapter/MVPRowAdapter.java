package org.enthusia.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.model.MVPRow;

import java.util.ArrayList;

public class MVPRowAdapter extends RecyclerView.Adapter<MVPRowAdapter.MyViewHolder> {

    private ArrayList<MVPRow> rows;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView sr_no, player_name, points, matches;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sr_no = itemView.findViewById(R.id.sr_no);
            player_name = itemView.findViewById(R.id.player_name);
            points = itemView.findViewById(R.id.player_points);
            matches = itemView.findViewById(R.id.matches);

        }
    }

    public MVPRowAdapter(ArrayList<MVPRow> rows) {
        this.rows = rows;
    }

    @NonNull
    @Override
    public MVPRowAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mvp_row,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MVPRowAdapter.MyViewHolder myViewHolder, int i) {
        MyViewHolder holder = myViewHolder;
        MVPRow row = rows.get(i);
        holder.sr_no.setText(row.getSr_no());
        holder.player_name.setText(row.getMVPName());
        holder.matches.setText(row.getMVPMatches());
        holder.points.setText(row.getMVPPoints());
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }
}
