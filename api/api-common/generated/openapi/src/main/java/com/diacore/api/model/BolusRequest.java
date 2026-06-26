package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BolusRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-26T17:35:52.036281+09:00[Asia/Seoul]")
public class BolusRequest {

  private Long userId;

  private Integer currentBg;

  private Integer targetBg;

  private Integer mealCarbsG;

  public BolusRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BolusRequest(Long userId, Integer currentBg, Integer targetBg, Integer mealCarbsG) {
    this.userId = userId;
    this.currentBg = currentBg;
    this.targetBg = targetBg;
    this.mealCarbsG = mealCarbsG;
  }

  public BolusRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
  @Schema(name = "currentBg", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @Schema(name = "targetBg", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @Schema(name = "mealCarbsG", requiredMode = Schema.RequiredMode.REQUIRED)
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
    return Objects.equals(this.userId, bolusRequest.userId) &&
        Objects.equals(this.currentBg, bolusRequest.currentBg) &&
        Objects.equals(this.targetBg, bolusRequest.targetBg) &&
        Objects.equals(this.mealCarbsG, bolusRequest.mealCarbsG);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, currentBg, targetBg, mealCarbsG);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BolusRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

