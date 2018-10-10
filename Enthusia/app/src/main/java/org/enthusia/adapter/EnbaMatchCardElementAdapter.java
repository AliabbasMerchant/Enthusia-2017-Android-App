package org.enthusia.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.model.MatchCard;
import org.enthusia.model.MatchCardElement;

import java.util.ArrayList;

public class EnbaMatchCardElementAdapter extends RecyclerView.Adapter<EnbaMatchCardElementAdapter.MyViewHolder> {

    private ArrayList<MatchCardElement> matchCardElementArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView leftTeam, rightTeam, score;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftTeam = itemView.findViewById(R.id.left_team_text_view);
            rightTeam = itemView.findViewById(R.id.right_team_text_view);
            score = itemView.findViewById(R.id.score_text_view);
        }
    }

    public EnbaMatchCardElementAdapter(ArrayList<MatchCardElement> arrayList) {
        this.matchCardElementArrayList = arrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.match_card_element, viewGroup, false);
        return new MyViewHolder(item);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MyViewHolder holder = myViewHolder;
        MatchCardElement matchCardElement = matchCardElementArrayList.get(i);

        holder.leftTeam.setText(matchCardElement.getLeftTeam());
        holder.rightTeam.setText(matchCardElement.getRightTeam());
        holder.score.setText(matchCardElement.getScore());
    }

    @Override
    public int getItemCount() {
        return matchCardElementArrayList.size();
    }
}
