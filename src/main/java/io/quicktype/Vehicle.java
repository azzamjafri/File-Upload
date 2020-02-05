package io.quicktype;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Vehicle {
    private long score;
    private String type;

    @JsonProperty("score")
    public long getScore() { return score; }
    @JsonProperty("score")
    public void setScore(long value) { this.score = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }
}
