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
 * TherapyParameterResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class TherapyParameterResponse {

  private Integer hour;

  private Float carbRatio;

  private Float insulinSensitivity;

  public TherapyParameterResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TherapyParameterResponse(Integer hour, Float carbRatio, Float insulinSensitivity) {
    this.hour = hour;
    this.carbRatio = carbRatio;
    this.insulinSensitivity = insulinSensitivity;
  }

  public TherapyParameterResponse hour(Integer hour) {
    this.hour = hour;
    return this;
  }

  /**
   * 요청한 기준 시간
   * @return hour
  */
  @NotNull
  @JsonProperty("hour")
  public Integer getHour() {
    return hour;
  }

  public void setHour(Integer hour) {
    this.hour = hour;
  }

  public TherapyParameterResponse carbRatio(Float carbRatio) {
    this.carbRatio = carbRatio;
    return this;
  }

  /**
   * 해당 시간에 적용되는 탄수비 (g/U)
   * @return carbRatio
  */
  @NotNull
  @JsonProperty("carbRatio")
  public Float getCarbRatio() {
    return carbRatio;
  }

  public void setCarbRatio(Float carbRatio) {
    this.carbRatio = carbRatio;
  }

  public TherapyParameterResponse insulinSensitivity(Float insulinSensitivity) {
    this.insulinSensitivity = insulinSensitivity;
    return this;
  }

  /**
   * 해당 시간에 적용되는 인슐린 민감도 (mg/dL/U)
   * @return insulinSensitivity
  */
  @NotNull
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
    TherapyParameterResponse therapyParameterResponse = (TherapyParameterResponse) o;
    return Objects.equals(this.hour, therapyParameterResponse.hour) &&
        Objects.equals(this.carbRatio, therapyParameterResponse.carbRatio) &&
        Objects.equals(this.insulinSensitivity, therapyParameterResponse.insulinSensitivity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hour, carbRatio, insulinSensitivity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TherapyParameterResponse {\n");
    sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
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

