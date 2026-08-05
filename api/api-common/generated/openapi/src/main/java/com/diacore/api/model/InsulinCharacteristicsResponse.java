package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * InsulinCharacteristicsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T09:32:30.746425+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class InsulinCharacteristicsResponse {

  private Float diaHours;

  private Integer peakMinutes;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public InsulinCharacteristicsResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InsulinCharacteristicsResponse(Float diaHours, Integer peakMinutes) {
    this.diaHours = diaHours;
    this.peakMinutes = peakMinutes;
  }

  public InsulinCharacteristicsResponse diaHours(Float diaHours) {
    this.diaHours = diaHours;
    return this;
  }

  /**
   * 인슐린 지속 시간 (Duration of Insulin Action, 시간 단위)
   * @return diaHours
  */
  @NotNull
  @JsonProperty("diaHours")
  public Float getDiaHours() {
    return diaHours;
  }

  public void setDiaHours(Float diaHours) {
    this.diaHours = diaHours;
  }

  public InsulinCharacteristicsResponse peakMinutes(Integer peakMinutes) {
    this.peakMinutes = peakMinutes;
    return this;
  }

  /**
   * 인슐린 최대 작용 시점 (Peak, 분 단위 - 예: 속효성 보통 60~90분)
   * @return peakMinutes
  */
  @NotNull
  @JsonProperty("peakMinutes")
  public Integer getPeakMinutes() {
    return peakMinutes;
  }

  public void setPeakMinutes(Integer peakMinutes) {
    this.peakMinutes = peakMinutes;
  }

  public InsulinCharacteristicsResponse updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
  */
  
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsulinCharacteristicsResponse insulinCharacteristicsResponse = (InsulinCharacteristicsResponse) o;
    return Objects.equals(this.diaHours, insulinCharacteristicsResponse.diaHours) &&
        Objects.equals(this.peakMinutes, insulinCharacteristicsResponse.peakMinutes) &&
        Objects.equals(this.updatedAt, insulinCharacteristicsResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(diaHours, peakMinutes, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsulinCharacteristicsResponse {\n");
    sb.append("    diaHours: ").append(toIndentedString(diaHours)).append("\n");
    sb.append("    peakMinutes: ").append(toIndentedString(peakMinutes)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

