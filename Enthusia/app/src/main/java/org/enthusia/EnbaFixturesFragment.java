package org.enthusia;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.enthusia.adapter.EnbaMatchCardAdapter;
import org.enthusia.model.MatchCard;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class EnbaFixturesFragment extends Fragment {
    private static final String TAG = "EnbaFixturesFragment";
    SwipeRefreshLayout swipeRefreshLayout;
    JSONObject fixturesData;
    ProgressBar progressBar;
    LinearLayout cont;

    public EnbaFixturesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_enba_fixtures, container, false);
        ArrayList<MatchCard> cards;
//        cards.add(new MatchCard(getActivity()));
//        cards.add(new MatchCard(getActivity()));
//        cards.add(new MatchCard(getActivity()));
//        EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
//        ListView listView = v.findViewById(R.id.match_card_list_view);
//        listView.setAdapter(adapter);

        ListView listView = v.findViewById(R.id.match_card_list_view);
        progressBar = v.findViewById(R.id.progressBar);
        cont = v.findViewById(R.id.cont);

        swipeRefreshLayout = v.findViewById(R.id.fixtures_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(()->{
            progressBar.setVisibility(View.VISIBLE);
            cont.setVisibility(View.GONE);

            getFixturesData();
//            inflateFixturesData();
        });
        getFixturesData();
//        getFixturesData();


        if(fixturesData!= null) {
            Log.d("Fixtures","Received Data!");
            cards = new ArrayList<>();
            Iterator iterator = fixturesData.keys();
            while(iterator.hasNext()) {
                String date = (String)iterator.next();
                try {
                    JSONArray array = fixturesData.getJSONArray(date);
                    cards.add(new MatchCard(getActivity(), array, date));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
            listView.setAdapter(adapter);
        }
//        inflateFixturesData();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                int topRowVerticalPostition = (listView==null || listView.getChildCount() == 0 )? 0: listView.getChildAt(0).getTop();
                swipeRefreshLayout.setEnabled(i == 0 && topRowVerticalPostition >=0);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    void getFixturesData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String pointsURL = getResources().getString(R.string.fixturesURL);
        StringRequest sr = new StringRequest(Request.Method.GET, pointsURL, response -> {
            Log.e(TAG, "onResponse: " + response);
            try {
                fixturesData = new JSONObject(response);
                inflateFixturesData();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.e(TAG, "onResponse: " + "Could not fetch data");
            Snackbar.make(getView(), "No internet connection!", Snackbar.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        });
        queue.add(sr);
    }
    void inflateFixturesData() {
        if(fixturesData!= null && getActivity()!=null) {
            ArrayList<MatchCard> cards = new ArrayList<>();
            Iterator iterator = fixturesData.keys();
            while(iterator.hasNext()) {
                String date = (String)iterator.next();
                try {
                    JSONArray array = fixturesData.getJSONArray(date);
                    cards.add(new MatchCard(getActivity(), array, date));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
            ListView listView = getView().findViewById(R.id.match_card_list_view);
            listView.setAdapter(adapter);
            swipeRefreshLayout.setRefreshing(false);
            progressBar.setVisibility(View.GONE);
            cont.setVisibility(View.VISIBLE);
//            swipeRefreshLayout.setVisibility(View.VISIBLE);
        }
    }

}
