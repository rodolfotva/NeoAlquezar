package com.neo.neoalquezar.service;

import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.neo.neoalquezar.model.Neo;
import com.neo.neoalquezar.model.NeoData;
import com.neo.neoalquezar.utils.NeoUtils;

@Component
public class NeoService implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(NeoService.class);

  @Override
  public void run(String... args) {
    try {
      logger.info("**********************************BEGIN**********************************");

      NeoData neoData = getNeoList();
      logger.info("Total number of NEOs: " + neoData.getPage().getTotalElements());
      logger.info("Total number of NEOs Today: " + neoData.getPage().getSize());

      LinkedHashMap<String, Neo> neoMap = NeoUtils.getNeoSortedByDiameter(neoData);

      Neo smallNeo = neoMap.get(neoMap.keySet().stream().findFirst().get());
      Neo bigNeo = neoMap.get(neoMap.keySet().stream().reduce((first, second) -> second).get());

      logger.info(System.lineSeparator() + System.lineSeparator() + " #### Small NEO ### " + System.lineSeparator() + smallNeo.toString() + System.lineSeparator());
      logger.info(System.lineSeparator() + System.lineSeparator() + " #### Big NEO ### " + System.lineSeparator() + bigNeo.toString() + System.lineSeparator());

      Neo caEarth = NeoUtils.getNeoIdFarFromEarth(neoMap);
      logger
          .info(System.lineSeparator() + System.lineSeparator() + " #### Closest NEO from Earth ### " + System.lineSeparator() + caEarth.toString() + System.lineSeparator());


    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    } finally {
      logger.info("***********************************END***********************************");
    }
  }

  private NeoData getNeoList() throws Exception {
    try {
      RestTemplate restTemplate = new RestTemplate();
      return restTemplate.getForObject("https://api.nasa.gov/neo/rest/v1/neo/browse?page=0&size=20&api_key=DEMO_KEY", NeoData.class);
    } catch (Exception ex) {
      throw new Exception("Error feed Neo list: " + ex.getMessage(), ex);
    }
  }

}
