package org.enthusia;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import org.enthusia.adapter.EnbaMatchCardAdapter;
import org.enthusia.model.MatchCard;

import java.util.ArrayList;

public class EnbaFixturesFragment extends Fragment {

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
        ArrayList<MatchCard> cards = new ArrayList<>();
        cards.add(new MatchCard(getActivity()));
        cards.add(new MatchCard(getActivity()));
        cards.add(new MatchCard(getActivity()));
        EnbaMatchCardAdapter adapter = new EnbaMatchCardAdapter(getActivity(), cards);
        ListView listView = v.findViewById(R.id.match_card_list_view);
        listView.setAdapter(adapter);

        SwipeRefreshLayout swipeLayout = v.findViewById(R.id.match_swipe_layout);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                int topRowVerticalPostition = (listView==null || listView.getChildCount() == 0 )? 0: listView.getChildAt(0).getTop();
                swipeLayout.setEnabled(i == 0 && topRowVerticalPostition >=0);
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

}
