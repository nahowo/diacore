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
 * BolusRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-22T16:00:42.322358+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class BolusRequest {

  private Integer currentBg;

  private Integer targetBg;

  private Integer mealCarbsG;

  public BolusRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BolusRequest(Integer currentBg, Integer targetBg, Integer mealCarbsG) {
    this.currentBg = currentBg;
    this.targetBg = targetBg;
    this.mealCarbsG = mealCarbsG;
  }

  public BolusRequest currentBg(Integer currentBg) {
    this.currentBg = currentBg;
    return this;
  }

  /**
   * Get currentBg
   * @return currentBg
  */
  @NotNull
  @JsonProperty("currentBg")
  public Integer getCurrentBg() {
    return currentBg;
  }

  public void setCurrentBg(Integer currentBg) {
    this.currentBg = currentBg;
  }

  public BolusRequest targetBg(Integer targetBg) {
    this.targetBg = targetBg;
    return this;
  }

  /**
   * Get targetBg
   * @return targetBg
  */
  @NotNull
  @JsonProperty("targetBg")
  public Integer getTargetBg() {
    return targetBg;
  }

  public void setTargetBg(Integer targetBg) {
    this.targetBg = targetBg;
  }

  public BolusRequest mealCarbsG(Integer mealCarbsG) {
    this.mealCarbsG = mealCarbsG;
    return this;
  }

  /**
   * Get mealCarbsG
   * @return mealCarbsG
  */
  @NotNull
  @JsonProperty("mealCarbsG")
  public Integer getMealCarbsG() {
    return mealCarbsG;
  }

  public void setMealCarbsG(Integer mealCarbsG) {
    this.mealCarbsG = mealCarbsG;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BolusRequest bolusRequest = (BolusRequest) o;
    return Objects.equals(this.currentBg, bolusRequest.currentBg) &&
        Objects.equals(this.targetBg, bolusRequest.targetBg) &&
        Objects.equals(this.mealCarbsG, bolusRequest.mealCarbsG);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentBg, targetBg, mealCarbsG);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BolusRequest {\n");
    sb.append("    currentBg: ").append(toIndentedString(currentBg)).append("\n");
    sb.append("    targetBg: ").append(toIndentedString(targetBg)).append("\n");
    sb.append("    mealCarbsG: ").append(toIndentedString(mealCarbsG)).append("\n");
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

