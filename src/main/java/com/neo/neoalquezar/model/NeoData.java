package com.neo.neoalquezar.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NeoData implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("links")
  private Links links;

  @JsonProperty("page")
  private Page page;

  @JsonProperty("near_earth_objects")
  private List<Neo> neoLst;


  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }

  public Page getPage() {
    return page;
  }

  public void setPage(Page page) {
    this.page = page;
  }

  public List<Neo> getNeoLst() {
    return neoLst;
  }

  public void setNeoLst(List<Neo> neoLst) {
    this.neoLst = neoLst;
  }

}
