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
 * GlucoseLogRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-26T20:02:31.020700+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class GlucoseLogRequest {

  private Long userId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Integer value;

  private String trendArrow;

  public GlucoseLogRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GlucoseLogRequest(Long userId, OffsetDateTime timestamp, Integer value) {
    this.userId = userId;
    this.timestamp = timestamp;
    this.value = value;
  }

  public GlucoseLogRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public GlucoseLogRequest timestamp(OffsetDateTime timestamp) {
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

  public GlucoseLogRequest value(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * glucose (mg/dL)
   * @return value
  */
  @NotNull
  @JsonProperty("value")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public GlucoseLogRequest trendArrow(String trendArrow) {
    this.trendArrow = trendArrow;
    return this;
  }

  /**
   * Get trendArrow
   * @return trendArrow
  */
  
  @JsonProperty("trendArrow")
  public String getTrendArrow() {
    return trendArrow;
  }

  public void setTrendArrow(String trendArrow) {
    this.trendArrow = trendArrow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlucoseLogRequest glucoseLogRequest = (GlucoseLogRequest) o;
    return Objects.equals(this.userId, glucoseLogRequest.userId) &&
        Objects.equals(this.timestamp, glucoseLogRequest.timestamp) &&
        Objects.equals(this.value, glucoseLogRequest.value) &&
        Objects.equals(this.trendArrow, glucoseLogRequest.trendArrow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, timestamp, value, trendArrow);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlucoseLogRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    trendArrow: ").append(toIndentedString(trendArrow)).append("\n");
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

