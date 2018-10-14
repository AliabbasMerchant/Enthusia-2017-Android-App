package org.enthusia.model;

public class MVPRow {
    String sr_no, name, points, matches;

    public MVPRow(String sr_no, String name, String points, String matches) {
        this.sr_no = sr_no;
        this.name = name;
        this.points = points;
        this.matches = matches;
    }

    public String getSr_no(){
        return sr_no;
    }

    public String getMVPName() {
        return name;
    }

    public String getMVPPoints() {
        return points;
    }

    public String getMVPMatches() {
        return matches;
    }
}
