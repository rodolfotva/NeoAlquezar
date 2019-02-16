package com.neo.neoalquezar.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Neo implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("neo_reference_id")
  private String neoReferenceId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("designation")
  private String designation;

  @JsonProperty("nasa_jpl_url")
  private String nasaJplUrl;

  @JsonProperty("is_potentially_hazardous_asteroid")
  private Boolean isDangerous;

  @JsonProperty("close_approach_data")
  private List<CloseApproach> closeApproach;

  private Double estimatedDiameter;
  private BigDecimal missDistance;


  @JsonProperty("estimated_diameter")
  public void getEstimatedDiameter(Map<String, Map<String, String>> value) {
    Double estimatedDiameterMin = Double.valueOf(value.get("meters").get("estimated_diameter_min"));
    Double estimatedDiameterMax = Double.valueOf(value.get("meters").get("estimated_diameter_max"));
    List<Double> primes = Arrays.asList(estimatedDiameterMax, estimatedDiameterMin);
    DoubleSummaryStatistics summary = primes.stream().mapToDouble((x) -> x).summaryStatistics();
    estimatedDiameter = summary.getAverage();
  }

  public String getNeoReferenceId() {
    return neoReferenceId;
  }

  public void setNeoReferenceId(String neoReferenceId) {
    this.neoReferenceId = neoReferenceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getNasaJplUrl() {
    return nasaJplUrl;
  }

  public void setNasaJplUrl(String nasaJplUrl) {
    this.nasaJplUrl = nasaJplUrl;
  }

  public Double getEstimatedDiameter() {
    return estimatedDiameter;
  }

  public void setEstimatedDiameter(Double estimatedDiameter) {
    this.estimatedDiameter = estimatedDiameter;
  }

  public Boolean getIsDangerous() {
    return isDangerous;
  }

  public void setIsDangerous(Boolean isDangerous) {
    this.isDangerous = isDangerous;
  }

  public BigDecimal getMissDistance() {
    return missDistance;
  }

  public void setMissDistance(BigDecimal missDistance) {
    this.missDistance = missDistance;
  }

  public List<CloseApproach> getCloseApproach() {
    return closeApproach;
  }

  public void setCloseApproach(List<CloseApproach> closeApproach) {
    this.closeApproach = closeApproach;
  }

  @Override
  public String toString() {
    String close = missDistance == null ? "" : System.lineSeparator() + " Miss Distance = " + missDistance + " Km" + System.lineSeparator() + closeApproach + " ";

    return System.lineSeparator() + " Reference Id = " + neoReferenceId
        + System.lineSeparator() + " Name = " + name
        + System.lineSeparator() + " Estimated Diameter = " + String.format("%.4f", estimatedDiameter) + " meters"
        + System.lineSeparator() + " Designation = " + designation
        + System.lineSeparator() + " Nasa Jpl Url = " + nasaJplUrl
        + System.lineSeparator() + " Is Dangerous = " + isDangerous
        + close;
  }

}
