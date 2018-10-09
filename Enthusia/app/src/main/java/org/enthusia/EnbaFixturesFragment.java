package org.enthusia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.enthusia.adapter.EnbaMatchCardAdapter;
import org.enthusia.model.MatchCard;

import java.util.ArrayList;

public class EnbaFixturesFragment extends Fragment {

//    private OnFragmentInteractionListener mListener;

    public EnbaFixturesFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_enba_fixtures, container, false);
        ArrayList<MatchCard> cards = new ArrayList<>();
        cards.add(new MatchCard(getActivity()));
        cards.add(new MatchCard(getActivity()));
        cards.add(new MatchCard(getActivity()));
        EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(),cards);
        ListView listView = v.findViewById(R.id.match_card_recycler_view);
        listView.setAdapter(adapter);
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

}
