package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.GlucoseLogResponse;
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
 * GlucoseLogPageResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T17:25:14.259910+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class GlucoseLogPageResponse {

  
  private List<GlucoseLogResponse> content = new ArrayList<>();

  private Long totalElements;

  private Integer pageNumber;

  public GlucoseLogPageResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GlucoseLogPageResponse(List<GlucoseLogResponse> content, Long totalElements) {
    this.content = content;
    this.totalElements = totalElements;
  }

  public GlucoseLogPageResponse content(List<GlucoseLogResponse> content) {
    this.content = content;
    return this;
  }

  public GlucoseLogPageResponse addContentItem(GlucoseLogResponse contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
  */
  @NotNull
  @JsonProperty("content")
  public List<GlucoseLogResponse> getContent() {
    return content;
  }

  public void setContent(List<GlucoseLogResponse> content) {
    this.content = content;
  }

  public GlucoseLogPageResponse totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
  */
  @NotNull
  @JsonProperty("totalElements")
  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public GlucoseLogPageResponse pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  /**
   * Get pageNumber
   * @return pageNumber
  */
  
  @JsonProperty("pageNumber")
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlucoseLogPageResponse glucoseLogPageResponse = (GlucoseLogPageResponse) o;
    return Objects.equals(this.content, glucoseLogPageResponse.content) &&
        Objects.equals(this.totalElements, glucoseLogPageResponse.totalElements) &&
        Objects.equals(this.pageNumber, glucoseLogPageResponse.pageNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, pageNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlucoseLogPageResponse {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
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

