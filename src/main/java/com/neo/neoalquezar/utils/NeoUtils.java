package com.neo.neoalquezar.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import com.neo.neoalquezar.model.CloseApproach;
import com.neo.neoalquezar.model.Neo;
import com.neo.neoalquezar.model.NeoData;

public class NeoUtils {

  public static LinkedHashMap<String, Neo> getNeoSortedByDiameter(NeoData neoData) throws Exception {
    return neoData.getNeoLst().stream().sorted((neo1, neo2) -> neo1.getEstimatedDiameter().compareTo(neo2.getEstimatedDiameter()))
        .collect(Collectors.toMap(Neo::getNeoReferenceId, c -> c, (oldVal, newVal) -> oldVal, LinkedHashMap::new));

  }

  public static Neo getNeoIdFarFromEarth(Map<String, Neo> neoMap) throws Exception {
    Map<String, BigDecimal> caEarthMap = new HashMap<>();

    List<Neo> neoLst = neoMap.values().stream().collect(Collectors.toList());

    for (Neo neo : neoLst) {
      CloseApproach caTmp = neo.getCloseApproach().stream().filter(close -> close.getOrbitingBody().equals("Earth"))
          .sorted((ca1, ca2) -> ca1.getMissDistance().compareTo(ca2.getMissDistance())).findFirst().orElse(null);

      if (Objects.nonNull(caTmp)) {
        caEarthMap.put(neo.getNeoReferenceId(), caTmp.getMissDistance());
      }
    }

    Entry<String, BigDecimal> entry = caEarthMap.entrySet().stream().sorted(Map.Entry.<String, BigDecimal>comparingByValue()).findFirst().get();
    Neo neo = neoMap.get(entry.getKey());
    neo.setMissDistance(entry.getValue());

    return neo;

  }

}
