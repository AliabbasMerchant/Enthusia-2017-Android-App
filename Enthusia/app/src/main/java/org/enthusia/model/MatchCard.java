package org.enthusia.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.adapter.EnbaMatchCardAdapter;
import org.enthusia.adapter.EnbaMatchCardElementAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MatchCard extends CardView{
    String date;
    JSONArray data;

    public JSONArray getData(){
        return data;
    }
    public String getDate(){
        return date;
    }

    ArrayList<MatchCardElement> matchCardElements;
    public MatchCard(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.match_card,this,true);
//        inflate_data();
    }

    public MatchCard(@NonNull Context context, JSONArray data, String date) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.match_card,this,true);
        this.data = data;
        this.date = date;
//        inflate_data();
    }

//    public void inflate_data() {
//    }
}

