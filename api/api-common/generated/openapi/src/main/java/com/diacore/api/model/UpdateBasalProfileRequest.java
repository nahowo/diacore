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
 * UpdateBasalProfileRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-29T16:05:14.336232+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class UpdateBasalProfileRequest {

  private Float dailyBasalUnits;

  private com.diacore.domain.profile.model.BasalInsulinName basalInsulinName;

  public UpdateBasalProfileRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateBasalProfileRequest(Float dailyBasalUnits) {
    this.dailyBasalUnits = dailyBasalUnits;
  }

  public UpdateBasalProfileRequest dailyBasalUnits(Float dailyBasalUnits) {
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

  public UpdateBasalProfileRequest basalInsulinName(com.diacore.domain.profile.model.BasalInsulinName basalInsulinName) {
    this.basalInsulinName = basalInsulinName;
    return this;
  }

  /**
   * Get basalInsulinName
   * @return basalInsulinName
  */
  
  @JsonProperty("basalInsulinName")
  public com.diacore.domain.profile.model.BasalInsulinName getBasalInsulinName() {
    return basalInsulinName;
  }

  public void setBasalInsulinName(com.diacore.domain.profile.model.BasalInsulinName basalInsulinName) {
    this.basalInsulinName = basalInsulinName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBasalProfileRequest updateBasalProfileRequest = (UpdateBasalProfileRequest) o;
    return Objects.equals(this.dailyBasalUnits, updateBasalProfileRequest.dailyBasalUnits) &&
        Objects.equals(this.basalInsulinName, updateBasalProfileRequest.basalInsulinName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dailyBasalUnits, basalInsulinName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBasalProfileRequest {\n");
    sb.append("    dailyBasalUnits: ").append(toIndentedString(dailyBasalUnits)).append("\n");
    sb.append("    basalInsulinName: ").append(toIndentedString(basalInsulinName)).append("\n");
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

