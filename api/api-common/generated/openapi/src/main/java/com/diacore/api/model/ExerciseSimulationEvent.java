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
 * ExerciseSimulationEvent
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-29T16:05:14.336232+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class ExerciseSimulationEvent {

  private com.diacore.domain.simulation.model.ExerciseIntensity intensity;

  private Integer durationMinutes;

  public ExerciseSimulationEvent() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExerciseSimulationEvent(com.diacore.domain.simulation.model.ExerciseIntensity intensity, Integer durationMinutes) {
    this.intensity = intensity;
    this.durationMinutes = durationMinutes;
  }

  public ExerciseSimulationEvent intensity(com.diacore.domain.simulation.model.ExerciseIntensity intensity) {
    this.intensity = intensity;
    return this;
  }

  /**
   * Get intensity
   * @return intensity
  */
  @NotNull
  @JsonProperty("intensity")
  public com.diacore.domain.simulation.model.ExerciseIntensity getIntensity() {
    return intensity;
  }

  public void setIntensity(com.diacore.domain.simulation.model.ExerciseIntensity intensity) {
    this.intensity = intensity;
  }

  public ExerciseSimulationEvent durationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
    return this;
  }

  /**
   * 예상 지속 시간 (분)
   * @return durationMinutes
  */
  @NotNull
  @JsonProperty("durationMinutes")
  public Integer getDurationMinutes() {
    return durationMinutes;
  }

  public void setDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExerciseSimulationEvent exerciseSimulationEvent = (ExerciseSimulationEvent) o;
    return Objects.equals(this.intensity, exerciseSimulationEvent.intensity) &&
        Objects.equals(this.durationMinutes, exerciseSimulationEvent.durationMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intensity, durationMinutes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExerciseSimulationEvent {\n");
    sb.append("    intensity: ").append(toIndentedString(intensity)).append("\n");
    sb.append("    durationMinutes: ").append(toIndentedString(durationMinutes)).append("\n");
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

