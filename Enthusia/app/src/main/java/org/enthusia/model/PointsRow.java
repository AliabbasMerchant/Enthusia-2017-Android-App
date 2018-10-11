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
        LayoutInflater.from(context).inflate(R.layout.match_card,this,true);
        inflate_data();
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
            sr_no.setText(data.getString("sr_no"));
            team_name.setText(data.getString("team_name"));
            p.setText(data.getString("p"));
            w.setText(data.getString("w"));
            l.setText(data.getString("l"));
            pf.setText(data.getString("pf"));
            pa.setText(data.getString("pa"));
            pts.setText(data.getString("pts"));
        } catch (JSONException e) {
            sr_no.setText("");
            team_name.setText("Team");
            p.setText("P");
            w.setText("W");
            l.setText("L");
            pf.setText("PF");
            pa.setText("PA");
            pts.setText("PTS");
        }
    }

}
