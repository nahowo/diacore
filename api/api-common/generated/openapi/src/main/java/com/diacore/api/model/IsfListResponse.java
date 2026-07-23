package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.IsfSegment;
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
 * IsfListResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T10:59:47.627344+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class IsfListResponse {

  
  private List<IsfSegment> segments = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public IsfListResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IsfListResponse(List<IsfSegment> segments, OffsetDateTime updatedAt) {
    this.segments = segments;
    this.updatedAt = updatedAt;
  }

  public IsfListResponse segments(List<IsfSegment> segments) {
    this.segments = segments;
    return this;
  }

  public IsfListResponse addSegmentsItem(IsfSegment segmentsItem) {
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
  public List<IsfSegment> getSegments() {
    return segments;
  }

  public void setSegments(List<IsfSegment> segments) {
    this.segments = segments;
  }

  public IsfListResponse updatedAt(OffsetDateTime updatedAt) {
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
    IsfListResponse isfListResponse = (IsfListResponse) o;
    return Objects.equals(this.segments, isfListResponse.segments) &&
        Objects.equals(this.updatedAt, isfListResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segments, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IsfListResponse {\n");
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

