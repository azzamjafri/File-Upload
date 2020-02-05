package io.quicktype;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Candidate {
    private double score;
    private String plate;

    @JsonProperty("score")
    public double getScore() { return score; }
    @JsonProperty("score")
    public void setScore(double value) { this.score = value; }

    @JsonProperty("plate")
    public String getPlate() { return plate; }
    @JsonProperty("plate")
    public void setPlate(String value) { this.plate = value; }
}
