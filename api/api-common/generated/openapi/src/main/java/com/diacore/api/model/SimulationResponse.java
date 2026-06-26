package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SimulationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-26T20:02:31.020700+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class SimulationResponse {

  private Integer predictedBg;

  private Integer recommendedCarbsG;

  private Float recommendedBolus;

  public SimulationResponse predictedBg(Integer predictedBg) {
    this.predictedBg = predictedBg;
    return this;
  }

  /**
   * result glucose
   * @return predictedBg
  */
  
  @JsonProperty("predictedBg")
  public Integer getPredictedBg() {
    return predictedBg;
  }

  public void setPredictedBg(Integer predictedBg) {
    this.predictedBg = predictedBg;
  }

  public SimulationResponse recommendedCarbsG(Integer recommendedCarbsG) {
    this.recommendedCarbsG = recommendedCarbsG;
    return this;
  }

  /**
   * recommended carb (g)
   * @return recommendedCarbsG
  */
  
  @JsonProperty("recommendedCarbsG")
  public Integer getRecommendedCarbsG() {
    return recommendedCarbsG;
  }

  public void setRecommendedCarbsG(Integer recommendedCarbsG) {
    this.recommendedCarbsG = recommendedCarbsG;
  }

  public SimulationResponse recommendedBolus(Float recommendedBolus) {
    this.recommendedBolus = recommendedBolus;
    return this;
  }

  /**
   * recommended insulin (Unit)
   * @return recommendedBolus
  */
  
  @JsonProperty("recommendedBolus")
  public Float getRecommendedBolus() {
    return recommendedBolus;
  }

  public void setRecommendedBolus(Float recommendedBolus) {
    this.recommendedBolus = recommendedBolus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimulationResponse simulationResponse = (SimulationResponse) o;
    return Objects.equals(this.predictedBg, simulationResponse.predictedBg) &&
        Objects.equals(this.recommendedCarbsG, simulationResponse.recommendedCarbsG) &&
        Objects.equals(this.recommendedBolus, simulationResponse.recommendedBolus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(predictedBg, recommendedCarbsG, recommendedBolus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimulationResponse {\n");
    sb.append("    predictedBg: ").append(toIndentedString(predictedBg)).append("\n");
    sb.append("    recommendedCarbsG: ").append(toIndentedString(recommendedCarbsG)).append("\n");
    sb.append("    recommendedBolus: ").append(toIndentedString(recommendedBolus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

