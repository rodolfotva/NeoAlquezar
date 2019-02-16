package com.neo.neoalquezar.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("size")
  private String size;

  @JsonProperty("total_elements")
  private String totalElements;

  @JsonProperty("total_pages")
  private String totalPages;

  @JsonProperty("number")
  private String number;

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(String totalElements) {
    this.totalElements = totalElements;
  }

  public String getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(String totalPages) {
    this.totalPages = totalPages;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }



}
