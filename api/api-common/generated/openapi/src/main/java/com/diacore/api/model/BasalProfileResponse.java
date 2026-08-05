package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BasalProfileResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T09:32:30.746425+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class BasalProfileResponse {

  private Float dailyBasalUnits;

  private com.diacore.domain.profile.model.BasalInsulinName basalInsulinName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public BasalProfileResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BasalProfileResponse(Float dailyBasalUnits, com.diacore.domain.profile.model.BasalInsulinName basalInsulinName) {
    this.dailyBasalUnits = dailyBasalUnits;
    this.basalInsulinName = basalInsulinName;
  }

  public BasalProfileResponse dailyBasalUnits(Float dailyBasalUnits) {
    this.dailyBasalUnits = dailyBasalUnits;
    return this;
  }

  /**
   * 하루 총 기저 인슐린 용량 (U)
   * @return dailyBasalUnits
  */
  @NotNull
  @JsonProperty("dailyBasalUnits")
  public Float getDailyBasalUnits() {
    return dailyBasalUnits;
  }

  public void setDailyBasalUnits(Float dailyBasalUnits) {
    this.dailyBasalUnits = dailyBasalUnits;
  }

  public BasalProfileResponse basalInsulinName(com.diacore.domain.profile.model.BasalInsulinName basalInsulinName) {
    this.basalInsulinName = basalInsulinName;
    return this;
  }

  /**
   * Get basalInsulinName
   * @return basalInsulinName
  */
  @NotNull
  @JsonProperty("basalInsulinName")
  public com.diacore.domain.profile.model.BasalInsulinName getBasalInsulinName() {
    return basalInsulinName;
  }

  public void setBasalInsulinName(com.diacore.domain.profile.model.BasalInsulinName basalInsulinName) {
    this.basalInsulinName = basalInsulinName;
  }

  public BasalProfileResponse updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
  */
  
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasalProfileResponse basalProfileResponse = (BasalProfileResponse) o;
    return Objects.equals(this.dailyBasalUnits, basalProfileResponse.dailyBasalUnits) &&
        Objects.equals(this.basalInsulinName, basalProfileResponse.basalInsulinName) &&
        Objects.equals(this.updatedAt, basalProfileResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dailyBasalUnits, basalInsulinName, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasalProfileResponse {\n");
    sb.append("    dailyBasalUnits: ").append(toIndentedString(dailyBasalUnits)).append("\n");
    sb.append("    basalInsulinName: ").append(toIndentedString(basalInsulinName)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

