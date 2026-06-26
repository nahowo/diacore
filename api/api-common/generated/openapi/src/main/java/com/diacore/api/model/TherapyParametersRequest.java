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
 * TherapyParametersRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-26T17:35:52.036281+09:00[Asia/Seoul]")
public class TherapyParametersRequest {

  private Long userId;

  private Float carbRatio;

  private Float insulinSensitivity;

  public TherapyParametersRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TherapyParametersRequest(Long userId, Float carbRatio, Float insulinSensitivity) {
    this.userId = userId;
    this.carbRatio = carbRatio;
    this.insulinSensitivity = insulinSensitivity;
  }

  public TherapyParametersRequest userId(Long userId) {
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

  public TherapyParametersRequest carbRatio(Float carbRatio) {
    this.carbRatio = carbRatio;
    return this;
  }

  /**
   * Get carbRatio
   * @return carbRatio
  */
  @NotNull 
  @Schema(name = "carbRatio", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("carbRatio")
  public Float getCarbRatio() {
    return carbRatio;
  }

  public void setCarbRatio(Float carbRatio) {
    this.carbRatio = carbRatio;
  }

  public TherapyParametersRequest insulinSensitivity(Float insulinSensitivity) {
    this.insulinSensitivity = insulinSensitivity;
    return this;
  }

  /**
   * Get insulinSensitivity
   * @return insulinSensitivity
  */
  @NotNull 
  @Schema(name = "insulinSensitivity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("insulinSensitivity")
  public Float getInsulinSensitivity() {
    return insulinSensitivity;
  }

  public void setInsulinSensitivity(Float insulinSensitivity) {
    this.insulinSensitivity = insulinSensitivity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TherapyParametersRequest therapyParametersRequest = (TherapyParametersRequest) o;
    return Objects.equals(this.userId, therapyParametersRequest.userId) &&
        Objects.equals(this.carbRatio, therapyParametersRequest.carbRatio) &&
        Objects.equals(this.insulinSensitivity, therapyParametersRequest.insulinSensitivity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, carbRatio, insulinSensitivity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TherapyParametersRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    carbRatio: ").append(toIndentedString(carbRatio)).append("\n");
    sb.append("    insulinSensitivity: ").append(toIndentedString(insulinSensitivity)).append("\n");
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

