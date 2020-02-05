package io.quicktype;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Box {
    private long ymin;
    private long xmin;
    private long ymax;
    private long xmax;

    @JsonProperty("ymin")
    public long getYmin() { return ymin; }
    @JsonProperty("ymin")
    public void setYmin(long value) { this.ymin = value; }

    @JsonProperty("xmin")
    public long getXmin() { return xmin; }
    @JsonProperty("xmin")
    public void setXmin(long value) { this.xmin = value; }

    @JsonProperty("ymax")
    public long getYmax() { return ymax; }
    @JsonProperty("ymax")
    public void setYmax(long value) { this.ymax = value; }

    @JsonProperty("xmax")
    public long getXmax() { return xmax; }
    @JsonProperty("xmax")
    public void setXmax(long value) { this.xmax = value; }
}
