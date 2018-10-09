package org.enthusia.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.adapter.EnbaMatchCardAdapter;
import org.enthusia.adapter.EnbaMatchCardElementAdapter;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MatchCard extends CardView{

    JSONObject data;


    public JSONObject getData(){
        return data;
    }

    ArrayList<MatchCardElement> matchCardElements;
    public MatchCard(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.match_card,this,true);
        inflate_data();
    }

    public void inflate_data(){

        matchCardElements= new ArrayList<>();
        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "20-20"));
        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "30-30"));
        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "40-40"));
        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "50-50"));

        RecyclerView recyclerView = findViewById(R.id.match_card_element_recycler_view);
        EnbaMatchCardElementAdapter adapter = new EnbaMatchCardElementAdapter(matchCardElements);
        recyclerView.setAdapter(adapter);


    }
}
