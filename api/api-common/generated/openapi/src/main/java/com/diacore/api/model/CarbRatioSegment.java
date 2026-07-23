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
 * CarbRatioSegment
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T10:59:47.627344+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class CarbRatioSegment {

  private Integer startTime;

  private Float value;

  public CarbRatioSegment() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CarbRatioSegment(Integer startTime, Float value) {
    this.startTime = startTime;
    this.value = value;
  }

  public CarbRatioSegment startTime(Integer startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * 시작 시간 (0~23)
   * @return startTime
  */
  @NotNull
  @JsonProperty("startTime")
  public Integer getStartTime() {
    return startTime;
  }

  public void setStartTime(Integer startTime) {
    this.startTime = startTime;
  }

  public CarbRatioSegment value(Float value) {
    this.value = value;
    return this;
  }

  /**
   * 탄수비 (g/U)
   * @return value
  */
  @NotNull
  @JsonProperty("value")
  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarbRatioSegment carbRatioSegment = (CarbRatioSegment) o;
    return Objects.equals(this.startTime, carbRatioSegment.startTime) &&
        Objects.equals(this.value, carbRatioSegment.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startTime, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarbRatioSegment {\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

