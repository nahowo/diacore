package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * RecommendedAction
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-29T16:05:14.336232+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class RecommendedAction {

  private com.diacore.domain.simulation.model.ActionType actionType;

  private Float suggestedValue;

  private String message;

  public RecommendedAction() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RecommendedAction(com.diacore.domain.simulation.model.ActionType actionType) {
    this.actionType = actionType;
  }

  public RecommendedAction actionType(com.diacore.domain.simulation.model.ActionType actionType) {
    this.actionType = actionType;
    return this;
  }

  /**
   * Get actionType
   * @return actionType
  */
  @NotNull
  @JsonProperty("actionType")
  public com.diacore.domain.simulation.model.ActionType getActionType() {
    return actionType;
  }

  public void setActionType(com.diacore.domain.simulation.model.ActionType actionType) {
    this.actionType = actionType;
  }

  public RecommendedAction suggestedValue(Float suggestedValue) {
    this.suggestedValue = suggestedValue;
    return this;
  }

  /**
   * 액션에 따른 수치 (기초율 u/hr, 볼러스 U, 또는 탄수화물 g)
   * @return suggestedValue
  */
  
  @JsonProperty("suggestedValue")
  public Float getSuggestedValue() {
    return suggestedValue;
  }

  public void setSuggestedValue(Float suggestedValue) {
    this.suggestedValue = suggestedValue;
  }

  public RecommendedAction message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecommendedAction recommendedAction = (RecommendedAction) o;
    return Objects.equals(this.actionType, recommendedAction.actionType) &&
        Objects.equals(this.suggestedValue, recommendedAction.suggestedValue) &&
        Objects.equals(this.message, recommendedAction.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actionType, suggestedValue, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecommendedAction {\n");
    sb.append("    actionType: ").append(toIndentedString(actionType)).append("\n");
    sb.append("    suggestedValue: ").append(toIndentedString(suggestedValue)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

