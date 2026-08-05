package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Nightscout 업로더(xDrip, Nightscout4iOS 등)가 전송하는 데이터 포맷
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T09:32:30.746425+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class NightscoutEntry {

  private String type;

  private Integer sgv;

  private String direction;

  private String device;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateString;

  private Long date;

  public NightscoutEntry type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public NightscoutEntry sgv(Integer sgv) {
    this.sgv = sgv;
    return this;
  }

  /**
   * 혈당 수치
   * @return sgv
  */
  
  @JsonProperty("sgv")
  public Integer getSgv() {
    return sgv;
  }

  public void setSgv(Integer sgv) {
    this.sgv = sgv;
  }

  public NightscoutEntry direction(String direction) {
    this.direction = direction;
    return this;
  }

  /**
   * 추세 화살표
   * @return direction
  */
  
  @JsonProperty("direction")
  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public NightscoutEntry device(String device) {
    this.device = device;
    return this;
  }

  /**
   * Get device
   * @return device
  */
  
  @JsonProperty("device")
  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public NightscoutEntry dateString(OffsetDateTime dateString) {
    this.dateString = dateString;
    return this;
  }

  /**
   * Get dateString
   * @return dateString
  */
  
  @JsonProperty("dateString")
  public OffsetDateTime getDateString() {
    return dateString;
  }

  public void setDateString(OffsetDateTime dateString) {
    this.dateString = dateString;
  }

  public NightscoutEntry date(Long date) {
    this.date = date;
    return this;
  }

  /**
   * Unix timestamp (ms)
   * @return date
  */
  
  @JsonProperty("date")
  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NightscoutEntry nightscoutEntry = (NightscoutEntry) o;
    return Objects.equals(this.type, nightscoutEntry.type) &&
        Objects.equals(this.sgv, nightscoutEntry.sgv) &&
        Objects.equals(this.direction, nightscoutEntry.direction) &&
        Objects.equals(this.device, nightscoutEntry.device) &&
        Objects.equals(this.dateString, nightscoutEntry.dateString) &&
        Objects.equals(this.date, nightscoutEntry.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, sgv, direction, device, dateString, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NightscoutEntry {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sgv: ").append(toIndentedString(sgv)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    dateString: ").append(toIndentedString(dateString)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

