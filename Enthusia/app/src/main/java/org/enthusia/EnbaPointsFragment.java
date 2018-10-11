package org.enthusia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.enthusia.adapter.EnbaMatchCardAdapter;
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
        getPointsData();
        if(pointsData!=null) {
            ArrayList<PointsRow> pointsRows = new ArrayList<>();
            try {
                JSONObject GroupA = pointsData.getJSONObject("Group A");
                JSONObject GroupB = pointsData.getJSONObject("Group B");
                for(int i=1; i<=5; i++) {
                    JSONObject object = GroupA.getJSONObject(Integer.toString(i));
                }
                for(int i=1; i<=5; i++) {
                    JSONObject object = GroupB.getJSONObject(Integer.toString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            ArrayList<MatchCard> cards = new ArrayList<>();
            cards.add(new MatchCard(getActivity()));
            cards.add(new MatchCard(getActivity()));
            cards.add(new MatchCard(getActivity()));
            EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
            ListView listView = v.findViewById(R.id.match_card_list_view);
            listView.setAdapter(adapter);

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
