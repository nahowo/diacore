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
 * InsulinLogResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T15:44:28.520575+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class InsulinLogResponse {

  private Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Float dose;

  private String insulinType;

  public InsulinLogResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InsulinLogResponse(Long id, OffsetDateTime timestamp, Float dose, String insulinType) {
    this.id = id;
    this.timestamp = timestamp;
    this.dose = dose;
    this.insulinType = insulinType;
  }

  public InsulinLogResponse id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public InsulinLogResponse timestamp(OffsetDateTime timestamp) {
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

  public InsulinLogResponse dose(Float dose) {
    this.dose = dose;
    return this;
  }

  /**
   * Get dose
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

  public InsulinLogResponse insulinType(String insulinType) {
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
    InsulinLogResponse insulinLogResponse = (InsulinLogResponse) o;
    return Objects.equals(this.id, insulinLogResponse.id) &&
        Objects.equals(this.timestamp, insulinLogResponse.timestamp) &&
        Objects.equals(this.dose, insulinLogResponse.dose) &&
        Objects.equals(this.insulinType, insulinLogResponse.insulinType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timestamp, dose, insulinType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsulinLogResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

