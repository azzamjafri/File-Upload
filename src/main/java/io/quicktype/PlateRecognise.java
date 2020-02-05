package io.quicktype;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlateRecognise {
    private double processingTime;
    private io.quicktype.Result[] results;
    private String filename;
    private long version;
    private Object cameraID;
    private String timestamp;

    @JsonProperty("processing_time")
    public double getProcessingTime() { return processingTime; }
    @JsonProperty("processing_time")
    public void setProcessingTime(double value) { this.processingTime = value; }

    @JsonProperty("results")
    public io.quicktype.Result[] getResults() { return results; }
    @JsonProperty("results")
    public void setResults(io.quicktype.Result[] value) { this.results = value; }

    @JsonProperty("filename")
    public String getFilename() { return filename; }
    @JsonProperty("filename")
    public void setFilename(String value) { this.filename = value; }

    @JsonProperty("version")
    public long getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(long value) { this.version = value; }

    @JsonProperty("camera_id")
    public Object getCameraID() { return cameraID; }
    @JsonProperty("camera_id")
    public void setCameraID(Object value) { this.cameraID = value; }

    @JsonProperty("timestamp")
    public String getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(String value) { this.timestamp = value; }
}
