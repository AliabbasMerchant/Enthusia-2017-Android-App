package org.enthusia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.model.MatchCard;
import org.enthusia.model.MatchCardElement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EnbaMatchCardAdapter extends BaseAdapter {

    private List<MatchCard> matchCards;
    private Activity activity;
    private LayoutInflater inflater;

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

        TextView date_tv = view.findViewById(R.id.date_tv);
        RecyclerView recyclerView = view.findViewById(R.id.match_card_element_recycler_view);
        MatchCard matchCard = matchCards.get(i);
        ArrayList<MatchCardElement> matchCardElements = new ArrayList<>();

        date_tv.setText(matchCard.getDate());
        JSONArray array = matchCard.getData();
        for(int k=0;k<array.length();k++) {
            try {
                JSONObject object = array.getJSONObject(i);
                String team_left = object.getString("team_left");
                String score = object.getString("score");
                String team_right = object.getString("team_right");
                matchCardElements.add(new MatchCardElement(team_left, team_right, score));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        RecyclerView.LayoutManager layoutManager = new CustomLinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),
//                DividerItemDecoration.VERTICAL));

        EnbaMatchCardElementAdapter adapter = new EnbaMatchCardElementAdapter(matchCardElements);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
