package org.enthusia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.enthusia.R;
import org.enthusia.model.MatchCard;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EnbaMatchCardAdapter extends BaseAdapter {

    private List<MatchCard> matchCards;
    private Activity activity;
    private LayoutInflater inflater;

    JSONObject data;


    public EnbaMatchCardAdapter(Activity activity, List<MatchCard> matchCards){
        super();
        this.activity = activity;
        this.matchCards = matchCards;
    }
    @Override
    public int getCount() {
        return matchCards.size();
    }

    @Override
    public Object getItem(int i) {
        return matchCards.get(i);
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
            view = inflater.inflate(R.layout.match_card, null);

//        data = matchCards.get(i).getData();

        return view;
    }
}
