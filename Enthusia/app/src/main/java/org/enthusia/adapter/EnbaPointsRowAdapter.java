package org.enthusia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.enthusia.R;
import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.model.MatchCard;
import org.enthusia.model.MatchCardElement;
import org.enthusia.model.PointsRow;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EnbaPointsRowAdapter extends BaseAdapter {

    private List<PointsRow> pointsRows;
    private Activity activity;
    private LayoutInflater inflater;

    public EnbaPointsRowAdapter(Activity activity, List<PointsRow> pointsRows) {
        super();
        this.activity = activity;
        this.pointsRows = pointsRows;
    }

    @Override
    public int getCount() {
        return pointsRows.size();
    }

    @Override
    public Object getItem(int i) {
        return pointsRows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.points_row, null);




//        RecyclerView recyclerView = view.findViewById(R.id.match_card_element_recycler_view);
//        matchCardElements = new ArrayList<>();
//        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "20-20"));
//        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "30-30"));
//        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "40-40"));
//        matchCardElements.add(new MatchCardElement("Team Left", "Team Right", "50-50"));

//        RecyclerView.LayoutManager layoutManager = new CustomLinearLayoutManager(view.getContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),
//                DividerItemDecoration.VERTICAL));
//
//        EnbaMatchCardElementAdapter adapter = new EnbaMatchCardElementAdapter(matchCardElements);
//        recyclerView.setAdapter(adapter);

        return view;
    }
}

