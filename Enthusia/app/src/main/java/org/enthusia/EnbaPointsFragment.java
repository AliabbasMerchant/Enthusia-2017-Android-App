package org.enthusia;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.adapter.EnbaPointsRowAdapter;
import org.enthusia.model.PointsRow;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EnbaPointsFragment extends Fragment {
    private static final String TAG = "EnbaPointsFragment";
    SwipeRefreshLayout points_swipe_refresh;
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
        View v = inflater.inflate(R.layout.fragment_enba_points, container, false);
        points_swipe_refresh = v.findViewById(R.id.points_swipe_refresh);
        points_swipe_refresh.setOnRefreshListener(()->{
            getPointsData();
        });
        getPointsData();

        if (pointsData != null) {
            try {
                JSONObject GroupA = pointsData.getJSONObject("Group A");
                ArrayList<PointsRow> rows = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    JSONObject data = GroupA.getJSONObject(Integer.toString(i));
                    String Sr_no = data.getString("sr_no");
                    String Team_name = data.getString("team_name");
                    String P = data.getString("p");
                    String W = data.getString("w");
                    String L = data.getString("l");
                    String Pf = data.getString("pf");
                    String Pa = data.getString("pa");
                    String Pts = data.getString("pts");
                    rows.add(new PointsRow(Sr_no, Team_name, P, W, L, Pf, Pa, Pts));
                }

                EnbaPointsRowAdapter adapter = new EnbaPointsRowAdapter(rows);
                RecyclerView recyclerView = v.findViewById(R.id.points_card_list_view);
                recyclerView.setAdapter(adapter);
                JSONObject GroupB = pointsData.getJSONObject("Group B");

                rows = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    JSONObject data = GroupB.getJSONObject(Integer.toString(i));
                    String Sr_no = data.getString("sr_no");
                    String Team_name = data.getString("team_name");
                    String P = data.getString("p");
                    String W = data.getString("w");
                    String L = data.getString("l");
                    String Pf = data.getString("pf");
                    String Pa = data.getString("pa");
                    String Pts = data.getString("pts");
                    rows.add(new PointsRow(Sr_no, Team_name, P, W, L, Pf, Pa, Pts));
                }
                adapter = new EnbaPointsRowAdapter(rows);
                recyclerView = v.findViewById(R.id.points_card_list_view_B);
                recyclerView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return v;
    }


    void getPointsData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String pointsURL = getResources().getString(R.string.pointsURL);
        StringRequest sr = new StringRequest(Request.Method.GET, pointsURL, response -> {
            Log.e(TAG, "onResponse: " + response);
            try {
                pointsData = new JSONObject(response);
                inflatePointsData();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.e(TAG, "onResponse: " + "Could not fetch data");
            Snackbar.make(getView(), "No internet connection!", Snackbar.LENGTH_SHORT).show();
            points_swipe_refresh.setRefreshing(false);
        });
        queue.add(sr);
    }

    void inflatePointsData() {
        if (pointsData != null) {
            try {
                JSONObject GroupA = pointsData.getJSONObject("Group A");
                ArrayList<PointsRow> rows = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    JSONObject data = GroupA.getJSONObject(Integer.toString(i));
                    String Sr_no = data.getString("sr_no");
                    String Team_name = data.getString("team_name");
                    String P = data.getString("p");
                    String W = data.getString("w");
                    String L = data.getString("l");
                    String Pf = data.getString("pf");
                    String Pa = data.getString("pa");
                    String Pts = data.getString("pts");
                    rows.add(new PointsRow(Sr_no, Team_name, P, W, L, Pf, Pa, Pts));
                }
                RecyclerView.LayoutManager layoutManager = new CustomLinearLayoutManager(getView().getContext());

                EnbaPointsRowAdapter adapter = new EnbaPointsRowAdapter(rows);
                RecyclerView recyclerView = getView().findViewById(R.id.points_card_list_view);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                JSONObject GroupB = pointsData.getJSONObject("Group B");

                rows = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    JSONObject data = GroupB.getJSONObject(Integer.toString(i));
                    String Sr_no = data.getString("sr_no");
                    String Team_name = data.getString("team_name");
                    String P = data.getString("p");
                    String W = data.getString("w");
                    String L = data.getString("l");
                    String Pf = data.getString("pf");
                    String Pa = data.getString("pa");
                    String Pts = data.getString("pts");
                    rows.add(new PointsRow(Sr_no, Team_name, P, W, L, Pf, Pa, Pts));
                }
                adapter = new EnbaPointsRowAdapter(rows);
                recyclerView = getView().findViewById(R.id.points_card_list_view_B);
                layoutManager = new CustomLinearLayoutManager(getView().getContext());
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()){
//                    @Override
//                    public boolean canScrollVertically() {
//                        return false;
//                    }
//                });
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                if(points_swipe_refresh != null){
                    points_swipe_refresh.setRefreshing(false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
