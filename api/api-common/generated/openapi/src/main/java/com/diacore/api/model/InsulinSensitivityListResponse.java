package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.InsulinSensitivitySegment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * InsulinSensitivityListResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T15:44:28.520575+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class InsulinSensitivityListResponse {

  
  private List<InsulinSensitivitySegment> segments = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public InsulinSensitivityListResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InsulinSensitivityListResponse(List<InsulinSensitivitySegment> segments, OffsetDateTime updatedAt) {
    this.segments = segments;
    this.updatedAt = updatedAt;
  }

  public InsulinSensitivityListResponse segments(List<InsulinSensitivitySegment> segments) {
    this.segments = segments;
    return this;
  }

  public InsulinSensitivityListResponse addSegmentsItem(InsulinSensitivitySegment segmentsItem) {
    if (this.segments == null) {
      this.segments = new ArrayList<>();
    }
    this.segments.add(segmentsItem);
    return this;
  }

  /**
   * Get segments
   * @return segments
  */
  @NotNull
  @JsonProperty("segments")
  public List<InsulinSensitivitySegment> getSegments() {
    return segments;
  }

  public void setSegments(List<InsulinSensitivitySegment> segments) {
    this.segments = segments;
  }

  public InsulinSensitivityListResponse updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
  */
  @NotNull
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
    InsulinSensitivityListResponse insulinSensitivityListResponse = (InsulinSensitivityListResponse) o;
    return Objects.equals(this.segments, insulinSensitivityListResponse.segments) &&
        Objects.equals(this.updatedAt, insulinSensitivityListResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segments, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsulinSensitivityListResponse {\n");
    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
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

