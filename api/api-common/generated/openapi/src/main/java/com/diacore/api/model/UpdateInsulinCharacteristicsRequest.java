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
 * UpdateInsulinCharacteristicsRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-31T08:39:54.111124+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class UpdateInsulinCharacteristicsRequest {

  private Float diaHours;

  private Integer peakMinutes;

  public UpdateInsulinCharacteristicsRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateInsulinCharacteristicsRequest(Float diaHours, Integer peakMinutes) {
    this.diaHours = diaHours;
    this.peakMinutes = peakMinutes;
  }

  public UpdateInsulinCharacteristicsRequest diaHours(Float diaHours) {
    this.diaHours = diaHours;
    return this;
  }

  /**
   * 인슐린 지속 시간 (시간 단위, 보통 3~6시간)
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

  public UpdateInsulinCharacteristicsRequest peakMinutes(Integer peakMinutes) {
    this.peakMinutes = peakMinutes;
    return this;
  }

  /**
   * 인슐린 최대 작용 시점 (분 단위)
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateInsulinCharacteristicsRequest updateInsulinCharacteristicsRequest = (UpdateInsulinCharacteristicsRequest) o;
    return Objects.equals(this.diaHours, updateInsulinCharacteristicsRequest.diaHours) &&
        Objects.equals(this.peakMinutes, updateInsulinCharacteristicsRequest.peakMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(diaHours, peakMinutes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateInsulinCharacteristicsRequest {\n");
    sb.append("    diaHours: ").append(toIndentedString(diaHours)).append("\n");
    sb.append("    peakMinutes: ").append(toIndentedString(peakMinutes)).append("\n");
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

