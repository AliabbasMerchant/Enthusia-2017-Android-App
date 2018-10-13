package org.enthusia.model;

import android.content.Context;
import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PointsTable {
    private String group_name;
    private JSONObject data;
    private ArrayList<PointsRow> pointsRows;

    public String getGroup_name() {
        return group_name;
    }

    public JSONObject getData() {
        return data;
    }


    public PointsTable(String group_name, JSONObject data) {
        this.group_name = group_name;
        this.data = data;
    }
}
