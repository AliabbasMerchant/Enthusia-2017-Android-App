package org.enthusia;

import android.content.Context;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class EnbaFixturesFragment extends Fragment {
    private static final String TAG = "EnbaFixturesFragment";
    JSONObject fixturesData;

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

        getFixturesData();

        if(fixturesData!= null) {
            ArrayList<MatchCard> cards = new ArrayList<>();
            Iterator iterator = fixturesData.keys();
            while(iterator.hasNext()) {
                // TODO
                /*
                $data = array(
		"Date_1" => array(
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>"")
		),
		"Date_2" => array(
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>""),
		array("team_left"=>"", "score" => "", "team_right"=>"")
		)
	);
                 */
                String date = (String)iterator.next();
                try {
                    JSONArray array = fixturesData.getJSONArray(date);
                    cards.add(new MatchCard(getActivity(), array, date));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
            ListView listView = v.findViewById(R.id.match_card_list_view);
            listView.setAdapter(adapter);
        }
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Log.e(TAG, "onResponse: " + "Could not fetch data"));
        queue.add(sr);
    }
}
