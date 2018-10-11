package org.enthusia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.adapter.EnbaMatchCardAdapter;
import org.enthusia.adapter.EnbaPointsRowAdapter;
import org.enthusia.model.MatchCard;
import org.enthusia.model.PointsRow;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EnbaPointsFragment extends Fragment {
    private static final String TAG = "EnbaPointsFragment";
    JSONObject pointsData = null;

//    private OnFragmentInteractionListener mListener;

    public EnbaPointsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_enba_points, container, false);
//        getPointsData();
//        if(pointsData!=null) {
//
//            ArrayList<MatchCard> cards = new ArrayList<>();
//            cards.add(new MatchCard(getActivity()));
//            cards.add(new MatchCard(getActivity()));
//            cards.add(new MatchCard(getActivity()));
//            EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
//            ListView listView = v.findViewById(R.id.match_card_list_view);
//            listView.setAdapter(adapter);
            ArrayList<PointsRow> rows = new ArrayList<>();
            rows.add(new PointsRow("1","CaffeineOverflow","3","3","0","288","280","6"));
            rows.add(new PointsRow("2","CaffeineOverflow","3","3","0","288","280","6"));
            rows.add(new PointsRow("3","CaffeineOverflow","3","3","0","288","280","6"));
            rows.add(new PointsRow("4","CaffeineOverflow","3","3","0","288","280","6"));
            rows.add(new PointsRow("5","CaffeineOverflow","3","3","0","288","280","6"));
            rows.add(new PointsRow("6","CaffeineOverflow","3","3","0","288","280","6"));

            EnbaPointsRowAdapter adapter = new EnbaPointsRowAdapter(rows);
            RecyclerView recyclerView = v.findViewById(R.id.points_card_list_view);

        RecyclerView.LayoutManager layoutManager = new CustomLinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
//        }
        return v;
    }

    void getPointsData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String pointsURL = getResources().getString(R.string.pointsURL);
        StringRequest sr = new StringRequest(Request.Method.GET, pointsURL, response -> {
            Log.e(TAG, "onResponse: " + response);
            try {
                pointsData = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Log.e(TAG, "onResponse: " + "Could not fetch data"));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
