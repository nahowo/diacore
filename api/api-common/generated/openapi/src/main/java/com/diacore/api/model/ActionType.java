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
 * 권장되는 조치 유형
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T09:32:30.746425+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public enum ActionType {
  
  MAINTAIN("MAINTAIN"),
  
  TEMP_BASAL("TEMP_BASAL"),
  
  SMB("SMB"),
  
  SUSPEND("SUSPEND"),
  
  CARB_SUGGESTION("CARB_SUGGESTION");

  private String value;

  ActionType(String value) {
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
  public static ActionType fromValue(String value) {
    for (ActionType b : ActionType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

