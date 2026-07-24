package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.MealLogResponse;
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
 * MealLogPageResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class MealLogPageResponse {

  
  private List<MealLogResponse> content = new ArrayList<>();

  private Long totalElements;

  private Integer pageNumber;

  public MealLogPageResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MealLogPageResponse(List<MealLogResponse> content, Long totalElements) {
    this.content = content;
    this.totalElements = totalElements;
  }

  public MealLogPageResponse content(List<MealLogResponse> content) {
    this.content = content;
    return this;
  }

  public MealLogPageResponse addContentItem(MealLogResponse contentItem) {
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
  public List<MealLogResponse> getContent() {
    return content;
  }

  public void setContent(List<MealLogResponse> content) {
    this.content = content;
  }

  public MealLogPageResponse totalElements(Long totalElements) {
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

  public MealLogPageResponse pageNumber(Integer pageNumber) {
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
    MealLogPageResponse mealLogPageResponse = (MealLogPageResponse) o;
    return Objects.equals(this.content, mealLogPageResponse.content) &&
        Objects.equals(this.totalElements, mealLogPageResponse.totalElements) &&
        Objects.equals(this.pageNumber, mealLogPageResponse.pageNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, pageNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealLogPageResponse {\n");
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

