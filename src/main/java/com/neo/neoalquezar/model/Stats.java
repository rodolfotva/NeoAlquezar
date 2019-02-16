package com.neo.neoalquezar.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("near_earth_object_count")
  private int nearEarthObjectCount;

  @JsonProperty("close_approach_count")
  private int closeApproachCount;

  @JsonProperty("last_updated")
  private String lastUpdated;

  @JsonProperty("source")
  private String source;

  @JsonProperty("nasa_jpl_url")
  private String nasaJplUrl;

  public int getNearEarthObjectCount() {
    return nearEarthObjectCount;
  }

  public void setNearEarthObjectCount(int nearEarthObjectCount) {
    this.nearEarthObjectCount = nearEarthObjectCount;
  }

  public int getCloseApproachCount() {
    return closeApproachCount;
  }

  public void setCloseApproachCount(int closeApproachCount) {
    this.closeApproachCount = closeApproachCount;
  }

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getNasaJplUrl() {
    return nasaJplUrl;
  }

  public void setNasaJplUrl(String nasaJplUrl) {
    this.nasaJplUrl = nasaJplUrl;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public String toString() {
    return "Stats [nearEarthObjectCount=" + nearEarthObjectCount + ", closeApproachCount=" + closeApproachCount + ", lastUpdated=" + lastUpdated + ", source=" + source
        + ", nasaJplUrl=" + nasaJplUrl + "]";
  }

}
