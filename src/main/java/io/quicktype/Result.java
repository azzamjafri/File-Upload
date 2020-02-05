package io.quicktype;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Result {
    private Box box;
    private String plate;
    private io.quicktype.Region region;
    private io.quicktype.Vehicle vehicle;
    private double score;
    private io.quicktype.Candidate[] candidates;

    @JsonProperty("box")
    public Box getBox() { return box; }
    @JsonProperty("box")
    public void setBox(Box value) { this.box = value; }

    @JsonProperty("plate")
    public String getPlate() { return plate; }
    @JsonProperty("plate")
    public void setPlate(String value) { this.plate = value; }

    @JsonProperty("region")
    public io.quicktype.Region getRegion() { return region; }
    @JsonProperty("region")
    public void setRegion(io.quicktype.Region value) { this.region = value; }

    @JsonProperty("vehicle")
    public io.quicktype.Vehicle getVehicle() { return vehicle; }
    @JsonProperty("vehicle")
    public void setVehicle(io.quicktype.Vehicle value) { this.vehicle = value; }

    @JsonProperty("score")
    public double getScore() { return score; }
    @JsonProperty("score")
    public void setScore(double value) { this.score = value; }

    @JsonProperty("candidates")
    public io.quicktype.Candidate[] getCandidates() { return candidates; }
    @JsonProperty("candidates")
    public void setCandidates(io.quicktype.Candidate[] value) { this.candidates = value; }

}

// Box.java

