package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * RecommendationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-23T11:47:03.300067+09:00[Asia/Seoul]")
public class RecommendationResponse {

  private Long id;

  private String parameterType;

  private Float originalValue;

  private Float recommendedValue;

  private String reasonText;

  public RecommendationResponse id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RecommendationResponse parameterType(String parameterType) {
    this.parameterType = parameterType;
    return this;
  }

  /**
   * Get parameterType
   * @return parameterType
  */
  
  @Schema(name = "parameterType", example = "CARB_RATIO", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parameterType")
  public String getParameterType() {
    return parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }

  public RecommendationResponse originalValue(Float originalValue) {
    this.originalValue = originalValue;
    return this;
  }

  /**
   * Get originalValue
   * @return originalValue
  */
  
  @Schema(name = "originalValue", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("originalValue")
  public Float getOriginalValue() {
    return originalValue;
  }

  public void setOriginalValue(Float originalValue) {
    this.originalValue = originalValue;
  }

  public RecommendationResponse recommendedValue(Float recommendedValue) {
    this.recommendedValue = recommendedValue;
    return this;
  }

  /**
   * Get recommendedValue
   * @return recommendedValue
  */
  
  @Schema(name = "recommendedValue", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recommendedValue")
  public Float getRecommendedValue() {
    return recommendedValue;
  }

  public void setRecommendedValue(Float recommendedValue) {
    this.recommendedValue = recommendedValue;
  }

  public RecommendationResponse reasonText(String reasonText) {
    this.reasonText = reasonText;
    return this;
  }

  /**
   * Get reasonText
   * @return reasonText
  */
  
  @Schema(name = "reasonText", example = "최근 7일간 아침 식후 고혈당 지속", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    RecommendationResponse recommendationResponse = (RecommendationResponse) o;
    return Objects.equals(this.id, recommendationResponse.id) &&
        Objects.equals(this.parameterType, recommendationResponse.parameterType) &&
        Objects.equals(this.originalValue, recommendationResponse.originalValue) &&
        Objects.equals(this.recommendedValue, recommendationResponse.recommendedValue) &&
        Objects.equals(this.reasonText, recommendationResponse.reasonText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parameterType, originalValue, recommendedValue, reasonText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecommendationResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parameterType: ").append(toIndentedString(parameterType)).append("\n");
    sb.append("    originalValue: ").append(toIndentedString(originalValue)).append("\n");
    sb.append("    recommendedValue: ").append(toIndentedString(recommendedValue)).append("\n");
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

