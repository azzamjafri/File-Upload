package io.quicktype;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Region {
    private double score;
    private String code;

    @JsonProperty("score")
    public double getScore() { return score; }
    @JsonProperty("score")
    public void setScore(double value) { this.score = value; }

    @JsonProperty("code")
    public String getCode() { return code; }
    @JsonProperty("code")
    public void setCode(String value) { this.code = value; }
}
