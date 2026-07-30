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
 * 기저 인슐린 종류
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-29T16:05:14.336232+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public enum BasalInsulinName {
  
  TRESIBA("TRESIBA"),
  
  LANTUS("LANTUS"),
  
  TOUJEO("TOUJEO"),
  
  LEVEMIR("LEVEMIR"),
  
  OTHER("OTHER");

  private String value;

  BasalInsulinName(String value) {
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
  public static BasalInsulinName fromValue(String value) {
    for (BasalInsulinName b : BasalInsulinName.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

