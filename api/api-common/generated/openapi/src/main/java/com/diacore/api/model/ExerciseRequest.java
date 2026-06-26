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
 * ExerciseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-26T17:35:52.036281+09:00[Asia/Seoul]")
public class ExerciseRequest {

  private Long userId;

  private String exerciseType;

  private Integer durationMinutes;

  private Integer currentBg;

  public ExerciseRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExerciseRequest(Long userId, String exerciseType, Integer durationMinutes, Integer currentBg) {
    this.userId = userId;
    this.exerciseType = exerciseType;
    this.durationMinutes = durationMinutes;
    this.currentBg = currentBg;
  }

  public ExerciseRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ExerciseRequest exerciseType(String exerciseType) {
    this.exerciseType = exerciseType;
    return this;
  }

  /**
   * Get exerciseType
   * @return exerciseType
  */
  @NotNull 
  @Schema(name = "exerciseType", example = "RUNNING", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("exerciseType")
  public String getExerciseType() {
    return exerciseType;
  }

  public void setExerciseType(String exerciseType) {
    this.exerciseType = exerciseType;
  }

  public ExerciseRequest durationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
    return this;
  }

  /**
   * Get durationMinutes
   * @return durationMinutes
  */
  @NotNull 
  @Schema(name = "durationMinutes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("durationMinutes")
  public Integer getDurationMinutes() {
    return durationMinutes;
  }

  public void setDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
  }

  public ExerciseRequest currentBg(Integer currentBg) {
    this.currentBg = currentBg;
    return this;
  }

  /**
   * Get currentBg
   * @return currentBg
  */
  @NotNull 
  @Schema(name = "currentBg", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentBg")
  public Integer getCurrentBg() {
    return currentBg;
  }

  public void setCurrentBg(Integer currentBg) {
    this.currentBg = currentBg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExerciseRequest exerciseRequest = (ExerciseRequest) o;
    return Objects.equals(this.userId, exerciseRequest.userId) &&
        Objects.equals(this.exerciseType, exerciseRequest.exerciseType) &&
        Objects.equals(this.durationMinutes, exerciseRequest.durationMinutes) &&
        Objects.equals(this.currentBg, exerciseRequest.currentBg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, exerciseType, durationMinutes, currentBg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExerciseRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    exerciseType: ").append(toIndentedString(exerciseType)).append("\n");
    sb.append("    durationMinutes: ").append(toIndentedString(durationMinutes)).append("\n");
    sb.append("    currentBg: ").append(toIndentedString(currentBg)).append("\n");
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

