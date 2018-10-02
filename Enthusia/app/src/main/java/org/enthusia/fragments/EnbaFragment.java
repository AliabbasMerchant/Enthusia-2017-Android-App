package org.enthusia.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.enthusia.R;
import org.w3c.dom.Text;

public class EnbaFragment extends Fragment {
    public EnbaFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enba,container, false);
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
}