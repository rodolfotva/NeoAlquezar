package com.neo.neoalquezar.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseApproach implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("close_approach_date")
  private String closeApproachDate;

  @JsonProperty("orbiting_body")
  private String orbitingBody;

  private Double relativeVelocity;
  private BigDecimal missDistance;

  @JsonProperty("relative_velocity")
  public void getRelativeVelocity(Map<String, String> value) {
    relativeVelocity = Double.valueOf(value.get("kilometers_per_hour"));
  }

  @JsonProperty("miss_distance")
  public void getMissDistance(Map<String, String> value) {
    setMissDistance(new BigDecimal(value.get("kilometers")));
  }

  public String getCloseApproachDate() {
    return closeApproachDate;
  }

  public void setCloseApproachDate(String closeApproachDate) {
    this.closeApproachDate = closeApproachDate;
  }

  public String getOrbitingBody() {
    return orbitingBody;
  }

  public void setOrbitingBody(String orbitingBody) {
    this.orbitingBody = orbitingBody;
  }

  public Double getRelativeVelocity() {
    return relativeVelocity;
  }

  public void setRelativeVelocity(Double relativeVelocity) {
    this.relativeVelocity = relativeVelocity;
  }

  public BigDecimal getMissDistance() {
    return missDistance;
  }

  public void setMissDistance(BigDecimal missDistance) {
    this.missDistance = missDistance;
  }

  @Override
  public String toString() {
    return " Close Approach Date = " + closeApproachDate
        + System.lineSeparator() + " Miss Distance = " + missDistance + " Km "
        + System.lineSeparator() + " Orbiting Body = " + orbitingBody
        + System.lineSeparator() + " Relative Velocity = " + String.format("%.4f", relativeVelocity) + " Km/h ";
  }

}
