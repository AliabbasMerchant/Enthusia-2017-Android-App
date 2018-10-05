package org.enthusia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnbaPoolFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EnbaPoolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnbaPoolFragment extends Fragment {


    public EnbaPoolFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_enba_pool, container, false);
        String[] groupAList = getResources().getStringArray(R.array.group_A_list);
        String[] groupBList = getResources().getStringArray(R.array.group_B_list);
        TableLayout groupAtable = view.findViewById(R.id.group_A_table_layout);
        TableLayout groupBtable = view.findViewById(R.id.group_B_table_layout);
        TableRow row;
        TextView[] textviews = new TextView[10];
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);

        for(int i = 0; i<=4; i++){

            row = new TableRow(view.getContext());
            row.setBackgroundResource(outValue.resourceId);
            textviews[i] = new TextView(view.getContext());
            textviews[i].setText(groupAList[i]);
            row.addView(textviews[i]);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("EnbaFragment","A row in table A was clicked");
                }
            });
            groupAtable.addView(row);

            row = new TableRow(view.getContext());
            row.setBackgroundResource(outValue.resourceId);
            textviews[i+5] = new TextView(view.getContext());
            textviews[i+5].setText(groupBList[i]);
            row.addView(textviews[i+5]);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("EnbaFragment","A row in table B was clicked");
                }
            });
            groupBtable.addView(row);
        }
        for(TextView tv : textviews){
            tv.setTextSize(16);
            tv.setPadding(50, 60, 8, 60);
        }

        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
