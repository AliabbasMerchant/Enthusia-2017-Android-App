package org.enthusia.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.enthusia.R;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PointsRow extends ConstraintLayout {
    TextView sr_no, team_name, p, w, l, pf, pa, pts;
    JSONObject data;
    public PointsRow(Context context) {
        super(context);
    }
    public PointsRow(Context context, JSONObject data) {
        super(context);
        this.data = data;
        LayoutInflater.from(context).inflate(R.layout.match_card,this,true);
        sr_no = findViewById(R.id.sr_no);
        team_name = findViewById(R.id.team_name);
        p = findViewById(R.id.p);
        w = findViewById(R.id.w);
        l = findViewById(R.id.l);
        pf = findViewById(R.id.pf);
        pa = findViewById(R.id.pa);
        pts = findViewById(R.id.pts);
        inflate_data();
    }
    public JSONObject getData(){
        return data;
    }

    public void inflate_data() {
        try {
            String Sr_no = data.getString("sr_no");
            String Team_name = data.getString("team_name");
            String P = data.getString("p");
            String W = data.getString("w");
            String L = data.getString("l");
            String Pf = data.getString("pf");
            String Pa = data.getString("pa");
            String Pts = data.getString("pts");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
