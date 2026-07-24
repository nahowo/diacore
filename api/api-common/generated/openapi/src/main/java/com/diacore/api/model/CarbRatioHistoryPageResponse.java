package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.ProfileSnapshotHistoryResponse;
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
 * CarbRatioHistoryPageResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class CarbRatioHistoryPageResponse {

  
  private List<ProfileSnapshotHistoryResponse> content = new ArrayList<>();

  private Integer totalPages;

  private Long totalElements;

  private Integer size;

  private Integer number;

  public CarbRatioHistoryPageResponse content(List<ProfileSnapshotHistoryResponse> content) {
    this.content = content;
    return this;
  }

  public CarbRatioHistoryPageResponse addContentItem(ProfileSnapshotHistoryResponse contentItem) {
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
  
  @JsonProperty("content")
  public List<ProfileSnapshotHistoryResponse> getContent() {
    return content;
  }

  public void setContent(List<ProfileSnapshotHistoryResponse> content) {
    this.content = content;
  }

  public CarbRatioHistoryPageResponse totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  
  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public CarbRatioHistoryPageResponse totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
  */
  
  @JsonProperty("totalElements")
  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public CarbRatioHistoryPageResponse size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
  */
  
  @JsonProperty("size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public CarbRatioHistoryPageResponse number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  
  @JsonProperty("number")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarbRatioHistoryPageResponse carbRatioHistoryPageResponse = (CarbRatioHistoryPageResponse) o;
    return Objects.equals(this.content, carbRatioHistoryPageResponse.content) &&
        Objects.equals(this.totalPages, carbRatioHistoryPageResponse.totalPages) &&
        Objects.equals(this.totalElements, carbRatioHistoryPageResponse.totalElements) &&
        Objects.equals(this.size, carbRatioHistoryPageResponse.size) &&
        Objects.equals(this.number, carbRatioHistoryPageResponse.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalPages, totalElements, size, number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarbRatioHistoryPageResponse {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

