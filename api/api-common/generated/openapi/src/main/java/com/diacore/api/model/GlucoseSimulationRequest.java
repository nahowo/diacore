package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.ExerciseSimulationEvent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GlucoseSimulationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-29T16:05:14.336232+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class GlucoseSimulationRequest {

  private Integer currentGlucose;

  private Float iob;

  private Float cob;

  private Integer bgMomentum;

  private Float plannedCarbs = null;

  private Float plannedInsulin;

  private ExerciseSimulationEvent plannedExercise;

  public GlucoseSimulationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GlucoseSimulationRequest(Integer currentGlucose, Float iob, Float cob) {
    this.currentGlucose = currentGlucose;
    this.iob = iob;
    this.cob = cob;
  }

  public GlucoseSimulationRequest currentGlucose(Integer currentGlucose) {
    this.currentGlucose = currentGlucose;
    return this;
  }

  /**
   * 현재 혈당 수치 (mg/dL)
   * @return currentGlucose
  */
  @NotNull
  @JsonProperty("currentGlucose")
  public Integer getCurrentGlucose() {
    return currentGlucose;
  }

  public void setCurrentGlucose(Integer currentGlucose) {
    this.currentGlucose = currentGlucose;
  }

  public GlucoseSimulationRequest iob(Float iob) {
    this.iob = iob;
    return this;
  }

  /**
   * 활성 인슐린 (Insulin On Board, U)
   * @return iob
  */
  @NotNull
  @JsonProperty("iob")
  public Float getIob() {
    return iob;
  }

  public void setIob(Float iob) {
    this.iob = iob;
  }

  public GlucoseSimulationRequest cob(Float cob) {
    this.cob = cob;
    return this;
  }

  /**
   * 활성 탄수화물 (Carbs On Board, g)
   * @return cob
  */
  @NotNull
  @JsonProperty("cob")
  public Float getCob() {
    return cob;
  }

  public void setCob(Float cob) {
    this.cob = cob;
  }

  public GlucoseSimulationRequest bgMomentum(Integer bgMomentum) {
    this.bgMomentum = bgMomentum;
    return this;
  }

  /**
   * 최근 혈당 변화율 (mg/dL / 5min) - 옵션
   * @return bgMomentum
  */
  
  @JsonProperty("bgMomentum")
  public Integer getBgMomentum() {
    return bgMomentum;
  }

  public void setBgMomentum(Integer bgMomentum) {
    this.bgMomentum = bgMomentum;
  }

  public GlucoseSimulationRequest plannedCarbs(Float plannedCarbs) {
    this.plannedCarbs = plannedCarbs;
    return this;
  }

  /**
   * 섭취 예정인 탄수화물 양 (g)
   * @return plannedCarbs
  */
  
  @JsonProperty("plannedCarbs")
  public Float getPlannedCarbs() {
    return plannedCarbs;
  }

  public void setPlannedCarbs(Float plannedCarbs) {
    this.plannedCarbs = plannedCarbs;
  }

  public GlucoseSimulationRequest plannedInsulin(Float plannedInsulin) {
    this.plannedInsulin = plannedInsulin;
    return this;
  }

  /**
   * 주입 예정인 인슐린 볼러스 (U)
   * @return plannedInsulin
  */
  
  @JsonProperty("plannedInsulin")
  public Float getPlannedInsulin() {
    return plannedInsulin;
  }

  public void setPlannedInsulin(Float plannedInsulin) {
    this.plannedInsulin = plannedInsulin;
  }

  public GlucoseSimulationRequest plannedExercise(ExerciseSimulationEvent plannedExercise) {
    this.plannedExercise = plannedExercise;
    return this;
  }

  /**
   * Get plannedExercise
   * @return plannedExercise
  */
  
  @JsonProperty("plannedExercise")
  public ExerciseSimulationEvent getPlannedExercise() {
    return plannedExercise;
  }

  public void setPlannedExercise(ExerciseSimulationEvent plannedExercise) {
    this.plannedExercise = plannedExercise;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlucoseSimulationRequest glucoseSimulationRequest = (GlucoseSimulationRequest) o;
    return Objects.equals(this.currentGlucose, glucoseSimulationRequest.currentGlucose) &&
        Objects.equals(this.iob, glucoseSimulationRequest.iob) &&
        Objects.equals(this.cob, glucoseSimulationRequest.cob) &&
        Objects.equals(this.bgMomentum, glucoseSimulationRequest.bgMomentum) &&
        Objects.equals(this.plannedCarbs, glucoseSimulationRequest.plannedCarbs) &&
        Objects.equals(this.plannedInsulin, glucoseSimulationRequest.plannedInsulin) &&
        Objects.equals(this.plannedExercise, glucoseSimulationRequest.plannedExercise);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentGlucose, iob, cob, bgMomentum, plannedCarbs, plannedInsulin, plannedExercise);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlucoseSimulationRequest {\n");
    sb.append("    currentGlucose: ").append(toIndentedString(currentGlucose)).append("\n");
    sb.append("    iob: ").append(toIndentedString(iob)).append("\n");
    sb.append("    cob: ").append(toIndentedString(cob)).append("\n");
    sb.append("    bgMomentum: ").append(toIndentedString(bgMomentum)).append("\n");
    sb.append("    plannedCarbs: ").append(toIndentedString(plannedCarbs)).append("\n");
    sb.append("    plannedInsulin: ").append(toIndentedString(plannedInsulin)).append("\n");
    sb.append("    plannedExercise: ").append(toIndentedString(plannedExercise)).append("\n");
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

