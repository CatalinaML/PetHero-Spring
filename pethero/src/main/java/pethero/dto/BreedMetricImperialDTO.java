package pethero.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BreedMetricImperialDTO {

    @JsonProperty("imperial")
    private String imperial;
    @JsonProperty("metric")
    private String metric;

    public String getImperial() {
        return imperial;
    }

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
