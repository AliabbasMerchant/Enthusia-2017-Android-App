package org.enthusia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.adapter.MVPRowAdapter;
import org.enthusia.model.MVPRow;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class EnbaStatsFragment extends Fragment {

    JSONObject statsData;
    SwipeRefreshLayout stats_swipe_refresh;
    LinearLayout cont;
    RecyclerView boys_stats, girls_stats;
    ProgressBar progressBar;
    TextView stat1, stat2;
    ArrayList<MVPRow> rows;

    public EnbaStatsFragment() {
        // Required empty public constructor
    }

    public static EnbaStatsFragment newInstance(String param1, String param2) {
        EnbaStatsFragment fragment = new EnbaStatsFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_enba_stats, container, false);
//        stat1 = v.findViewById(R.id.stats_b);
//        stat2 = v.findViewById(R.id.stats_g);

        boys_stats = v.findViewById(R.id.mvp_boys_recycler_view);
        girls_stats = v.findViewById(R.id.mvp_girls_recycler_view);

        stats_swipe_refresh = v.findViewById(R.id.stats_swipe_refresh);
        progressBar = v.findViewById(R.id.progressBar);
        cont = v.findViewById(R.id.container);
        stats_swipe_refresh.setOnRefreshListener(() -> {
            getStatsData();
        });
        getStatsData();

        return v;
    }
    void getStatsData() {
        stats_swipe_refresh.setRefreshing(true);
        cont.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String pointsURL = getResources().getString(R.string.pointsURL);
        StringRequest sr = new StringRequest(Request.Method.GET, pointsURL, response -> {
            Log.e("Stats", "onResponse: " + response);
            try {
                statsData = new JSONObject(response);
                inflateStatsData();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.e("Stats", "onResponse: " + "Could not fetch data");
            Snackbar.make(getView(), "No internet connection!", Snackbar.LENGTH_SHORT).show();
            stats_swipe_refresh.setRefreshing(false);
        });
        queue.add(sr);
    }

    void inflateStatsData(){
        if(statsData!=null){
            try{
                JSONArray stats_b = statsData.getJSONArray("stats_b");
                JSONArray stats_g = statsData.getJSONArray("stats_g");
                rows = new ArrayList<>();
                JSONObject data;
                String sr_no, name, points, matches;
                for(int i = 0; i< stats_b.length(); i++){
                    data = stats_b.getJSONObject(i);
                    sr_no = Integer.toString(i+1);
                    name = data.getString("name");
                    points = data.getString("points");
                    matches = data.getString("matches");
                    rows.add(new MVPRow(sr_no,name, points,matches));
                }

                boys_stats.setLayoutManager(new CustomLinearLayoutManager(getView().getContext()));
                MVPRowAdapter adapter = new MVPRowAdapter(rows);
                boys_stats.setAdapter(adapter);

                rows = new ArrayList<>();

                for(int i = 0; i< stats_g.length(); i++){
                    data = stats_g.getJSONObject(i);
                    sr_no = Integer.toString(i+1);
                    name = data.getString("name");
                    points = data.getString("points");
                    matches = data.getString("matches");
                    rows.add(new MVPRow(sr_no,name, points,matches));
                }
                girls_stats.setLayoutManager(new CustomLinearLayoutManager(getView().getContext()));
                adapter = new MVPRowAdapter(rows);
                girls_stats.setAdapter(adapter);

                stats_swipe_refresh.setRefreshing(false);
                progressBar.setVisibility(View.GONE);
                cont.setVisibility(View.VISIBLE);
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
