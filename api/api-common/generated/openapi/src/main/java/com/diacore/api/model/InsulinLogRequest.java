package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * InsulinLogRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-23T11:47:03.300067+09:00[Asia/Seoul]")
public class InsulinLogRequest {

  private Long userId;

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
  public InsulinLogRequest(Long userId, OffsetDateTime timestamp, Float dose, String insulinType) {
    this.userId = userId;
    this.timestamp = timestamp;
    this.dose = dose;
    this.insulinType = insulinType;
  }

  public InsulinLogRequest userId(Long userId) {
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

  public InsulinLogRequest timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  */
  @NotNull @Valid 
  @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @Schema(name = "dose", description = "insulin (Unit)", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @Schema(name = "insulinType", example = "RAPID_ACTING", requiredMode = Schema.RequiredMode.REQUIRED)
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
    return Objects.equals(this.userId, insulinLogRequest.userId) &&
        Objects.equals(this.timestamp, insulinLogRequest.timestamp) &&
        Objects.equals(this.dose, insulinLogRequest.dose) &&
        Objects.equals(this.insulinType, insulinLogRequest.insulinType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, timestamp, dose, insulinType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsulinLogRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

