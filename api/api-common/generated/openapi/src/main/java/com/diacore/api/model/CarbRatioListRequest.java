package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.CarbRatioSegment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CarbRatioListRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class CarbRatioListRequest {

  
  private List<CarbRatioSegment> segments = new ArrayList<>();

  private com.diacore.domain.profile.model.ChangeSource changeSource;

  private String reasonText;

  public CarbRatioListRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CarbRatioListRequest(List<CarbRatioSegment> segments, com.diacore.domain.profile.model.ChangeSource changeSource) {
    this.segments = segments;
    this.changeSource = changeSource;
  }

  public CarbRatioListRequest segments(List<CarbRatioSegment> segments) {
    this.segments = segments;
    return this;
  }

  public CarbRatioListRequest addSegmentsItem(CarbRatioSegment segmentsItem) {
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
  public List<CarbRatioSegment> getSegments() {
    return segments;
  }

  public void setSegments(List<CarbRatioSegment> segments) {
    this.segments = segments;
  }

  public CarbRatioListRequest changeSource(com.diacore.domain.profile.model.ChangeSource changeSource) {
    this.changeSource = changeSource;
    return this;
  }

  /**
   * Get changeSource
   * @return changeSource
  */
  @NotNull
  @JsonProperty("changeSource")
  public com.diacore.domain.profile.model.ChangeSource getChangeSource() {
    return changeSource;
  }

  public void setChangeSource(com.diacore.domain.profile.model.ChangeSource changeSource) {
    this.changeSource = changeSource;
  }

  public CarbRatioListRequest reasonText(String reasonText) {
    this.reasonText = reasonText;
    return this;
  }

  /**
   * 변경 상세 사유 (선택 사항)
   * @return reasonText
  */
  
  @JsonProperty("reasonText")
  public String getReasonText() {
    return reasonText;
  }

  public void setReasonText(String reasonText) {
    this.reasonText = reasonText;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarbRatioListRequest carbRatioListRequest = (CarbRatioListRequest) o;
    return Objects.equals(this.segments, carbRatioListRequest.segments) &&
        Objects.equals(this.changeSource, carbRatioListRequest.changeSource) &&
        Objects.equals(this.reasonText, carbRatioListRequest.reasonText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segments, changeSource, reasonText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarbRatioListRequest {\n");
    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
    sb.append("    changeSource: ").append(toIndentedString(changeSource)).append("\n");
    sb.append("    reasonText: ").append(toIndentedString(reasonText)).append("\n");
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

