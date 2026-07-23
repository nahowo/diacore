package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.InsulinSensitivitySegment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * InsulinSensitivityListRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T17:25:14.259910+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class InsulinSensitivityListRequest {

  
  private List<InsulinSensitivitySegment> segments = new ArrayList<>();

  public InsulinSensitivityListRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InsulinSensitivityListRequest(List<InsulinSensitivitySegment> segments) {
    this.segments = segments;
  }

  public InsulinSensitivityListRequest segments(List<InsulinSensitivitySegment> segments) {
    this.segments = segments;
    return this;
  }

  public InsulinSensitivityListRequest addSegmentsItem(InsulinSensitivitySegment segmentsItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsulinSensitivityListRequest insulinSensitivityListRequest = (InsulinSensitivityListRequest) o;
    return Objects.equals(this.segments, insulinSensitivityListRequest.segments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsulinSensitivityListRequest {\n");
    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
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

