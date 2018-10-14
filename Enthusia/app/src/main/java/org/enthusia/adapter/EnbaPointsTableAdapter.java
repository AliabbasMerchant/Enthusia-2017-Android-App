package org.enthusia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.enthusia.R;
import org.enthusia.Utility.CustomLinearLayoutManager;
import org.enthusia.model.PointsRow;
import org.enthusia.model.PointsTable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EnbaPointsTableAdapter extends BaseAdapter {

    public class MyViewHolder {
        TextView group_tv;
        RecyclerView recyclerView;
    }

    private List<PointsTable> pointsTables;
    private Activity activity;
    private LayoutInflater inflater;

    public EnbaPointsTableAdapter(List<PointsTable> pointsTables, Activity activity) {
        this.pointsTables = pointsTables;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return pointsTables.size();
    }

    @Override
    public Object getItem(int i) {
        return pointsTables.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyViewHolder holder;

        if(inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null) {
            view = inflater.inflate(R.layout.points_table, null);
            holder = new MyViewHolder();
            holder.group_tv = view.findViewById(R.id.group_name);
            holder.recyclerView = view.findViewById(R.id.points_card_list_view);
            view.setTag(holder);
        }
        else{
            holder = (MyViewHolder) view.getTag();
        }

        PointsTable table = pointsTables.get(i);
        ArrayList<PointsRow> rows = new ArrayList<>();


        holder.group_tv.setText(table.getGroup_name());
        JSONObject array = table.getData();
        for(int k = 1; k<= array.length();k++){
            try{
                JSONObject data = array.getJSONObject(Integer.toString(k));
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
            catch (JSONException e){
                e.printStackTrace();
            }
        }
        Log.d("EnbaPointsTableAdapter","size of rows = "+rows.size());
        RecyclerView.LayoutManager layoutManager = new CustomLinearLayoutManager(view.getContext());
        EnbaPointsRowAdapter adapter = new EnbaPointsRowAdapter(rows);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(adapter);

        return view;
    }
}
