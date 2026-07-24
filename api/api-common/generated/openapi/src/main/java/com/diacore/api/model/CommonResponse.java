package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CommonResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class CommonResponse {

  private Boolean success;

  private String code;

  private String message;

  
  private Map<String, Object> data = new HashMap<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public CommonResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CommonResponse(Boolean success, String code, String message, OffsetDateTime timestamp) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.timestamp = timestamp;
  }

  public CommonResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * API 요청 성공 여부
   * @return success
  */
  @NotNull
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public CommonResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * 비즈니스 응답 코드
   * @return code
  */
  @NotNull
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CommonResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 응답 메시지
   * @return message
  */
  @NotNull
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public CommonResponse data(Map<String, Object> data) {
    this.data = data;
    return this;
  }

  public CommonResponse putDataItem(String key, Object dataItem) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, dataItem);
    return this;
  }

  /**
   * 응답 데이터
   * @return data
  */
  
  @JsonProperty("data")
  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  public CommonResponse timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * 응답 발생 시각
   * @return timestamp
  */
  @NotNull
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonResponse commonResponse = (CommonResponse) o;
    return Objects.equals(this.success, commonResponse.success) &&
        Objects.equals(this.code, commonResponse.code) &&
        Objects.equals(this.message, commonResponse.message) &&
        Objects.equals(this.data, commonResponse.data) &&
        Objects.equals(this.timestamp, commonResponse.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, code, message, data, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

