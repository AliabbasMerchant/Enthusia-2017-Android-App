package org.enthusia.model;

import android.widget.TextView;

public class MatchCardElement {
    public MatchCardElement(String leftTeam, String rightTeam, String score) {
        this.leftTeam = leftTeam;
        this.rightTeam = rightTeam;
        this.score = score;
    }

    public String getLeftTeam() {
        return leftTeam;
    }

    public void setLeftTeam(String leftTeam) {
        this.leftTeam = leftTeam;
    }

    public String getRightTeam() {
        return rightTeam;
    }

    public void setRightTeam(String rightTeam) {
        this.rightTeam = rightTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    String leftTeam;
    String rightTeam;
    String score;
}
