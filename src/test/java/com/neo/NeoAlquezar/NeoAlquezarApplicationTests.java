package com.neo.NeoAlquezar;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.neo.neoalquezar.model.Stats;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NeoAlquezarApplicationTests {

  @Test
  public void contextLoads() {}

  @Test
  public void retrieveCurrentNeoStatistics() {
    try {
      RestTemplate restTemplate = new RestTemplate();
      Stats stats = restTemplate.getForObject("https://api.nasa.gov/neo/rest/v1/stats?api_key=DEMO_KEY", Stats.class);
      assertThat(stats.getNasaJplUrl(), CoreMatchers.containsString("http://neo.jpl.nasa.gov/"));
    } catch (Exception ex) {
      Assert.fail("Exception " + ex);
    }
  }

}

