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
 * InsulinLogRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class InsulinLogRequest {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Float dose;

  private String insulinType;

  public InsulinLogRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InsulinLogRequest(OffsetDateTime timestamp, Float dose, String insulinType) {
    this.timestamp = timestamp;
    this.dose = dose;
    this.insulinType = insulinType;
  }

  public InsulinLogRequest timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  */
  @NotNull
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public InsulinLogRequest dose(Float dose) {
    this.dose = dose;
    return this;
  }

  /**
   * insulin (Unit)
   * @return dose
  */
  @NotNull
  @JsonProperty("dose")
  public Float getDose() {
    return dose;
  }

  public void setDose(Float dose) {
    this.dose = dose;
  }

  public InsulinLogRequest insulinType(String insulinType) {
    this.insulinType = insulinType;
    return this;
  }

  /**
   * Get insulinType
   * @return insulinType
  */
  @NotNull
  @JsonProperty("insulinType")
  public String getInsulinType() {
    return insulinType;
  }

  public void setInsulinType(String insulinType) {
    this.insulinType = insulinType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsulinLogRequest insulinLogRequest = (InsulinLogRequest) o;
    return Objects.equals(this.timestamp, insulinLogRequest.timestamp) &&
        Objects.equals(this.dose, insulinLogRequest.dose) &&
        Objects.equals(this.insulinType, insulinLogRequest.insulinType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, dose, insulinType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsulinLogRequest {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    dose: ").append(toIndentedString(dose)).append("\n");
    sb.append("    insulinType: ").append(toIndentedString(insulinType)).append("\n");
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

