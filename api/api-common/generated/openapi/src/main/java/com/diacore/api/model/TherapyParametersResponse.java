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
 * TherapyParametersResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-21T20:57:04.206910+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class TherapyParametersResponse {

  private Float carbRatio;

  private Float insulinSensitivity;

  public TherapyParametersResponse carbRatio(Float carbRatio) {
    this.carbRatio = carbRatio;
    return this;
  }

  /**
   * carb ratio (g/U)
   * @return carbRatio
  */
  
  @JsonProperty("carbRatio")
  public Float getCarbRatio() {
    return carbRatio;
  }

  public void setCarbRatio(Float carbRatio) {
    this.carbRatio = carbRatio;
  }

  public TherapyParametersResponse insulinSensitivity(Float insulinSensitivity) {
    this.insulinSensitivity = insulinSensitivity;
    return this;
  }

  /**
   * insulin sensitivity (mg/dL/U)
   * @return insulinSensitivity
  */
  
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
    TherapyParametersResponse therapyParametersResponse = (TherapyParametersResponse) o;
    return Objects.equals(this.carbRatio, therapyParametersResponse.carbRatio) &&
        Objects.equals(this.insulinSensitivity, therapyParametersResponse.insulinSensitivity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carbRatio, insulinSensitivity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TherapyParametersResponse {\n");
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

