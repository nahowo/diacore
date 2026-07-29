package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 운동 강도
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-28T21:19:11.515491+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public enum ExerciseIntensity {
  
  LOW("LOW"),
  
  MEDIUM("MEDIUM"),
  
  HIGH("HIGH");

  private String value;

  ExerciseIntensity(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ExerciseIntensity fromValue(String value) {
    for (ExerciseIntensity b : ExerciseIntensity.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

