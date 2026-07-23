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
 * GlucoseLogResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T10:59:47.627344+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class GlucoseLogResponse {

  private Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Integer value;

  private String trendArrow;

  private String source;

  public GlucoseLogResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GlucoseLogResponse(Long id, OffsetDateTime timestamp, Integer value) {
    this.id = id;
    this.timestamp = timestamp;
    this.value = value;
  }

  public GlucoseLogResponse id(Long id) {
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

  public GlucoseLogResponse timestamp(OffsetDateTime timestamp) {
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

  public GlucoseLogResponse value(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
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

  public GlucoseLogResponse trendArrow(String trendArrow) {
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

  public GlucoseLogResponse source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
  */
  
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlucoseLogResponse glucoseLogResponse = (GlucoseLogResponse) o;
    return Objects.equals(this.id, glucoseLogResponse.id) &&
        Objects.equals(this.timestamp, glucoseLogResponse.timestamp) &&
        Objects.equals(this.value, glucoseLogResponse.value) &&
        Objects.equals(this.trendArrow, glucoseLogResponse.trendArrow) &&
        Objects.equals(this.source, glucoseLogResponse.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timestamp, value, trendArrow, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlucoseLogResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    trendArrow: ").append(toIndentedString(trendArrow)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

