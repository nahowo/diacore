package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.TherapySegment;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ProfileSnapshotHistoryResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-24T14:39:54.676685+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class ProfileSnapshotHistoryResponse {

  
  private List<TherapySegment> snapshotSegments = new ArrayList<>();

  private com.diacore.domain.profile.model.ChangeSource changeSource;

  private String reasonText;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  public ProfileSnapshotHistoryResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProfileSnapshotHistoryResponse(List<TherapySegment> snapshotSegments, com.diacore.domain.profile.model.ChangeSource changeSource, OffsetDateTime createdAt) {
    this.snapshotSegments = snapshotSegments;
    this.changeSource = changeSource;
    this.createdAt = createdAt;
  }

  public ProfileSnapshotHistoryResponse snapshotSegments(List<TherapySegment> snapshotSegments) {
    this.snapshotSegments = snapshotSegments;
    return this;
  }

  public ProfileSnapshotHistoryResponse addSnapshotSegmentsItem(TherapySegment snapshotSegmentsItem) {
    if (this.snapshotSegments == null) {
      this.snapshotSegments = new ArrayList<>();
    }
    this.snapshotSegments.add(snapshotSegmentsItem);
    return this;
  }

  /**
   * 변경되기 직전의 전체 24시간 세그먼트 데이터 (스냅샷)
   * @return snapshotSegments
  */
  @NotNull
  @JsonProperty("snapshotSegments")
  public List<TherapySegment> getSnapshotSegments() {
    return snapshotSegments;
  }

  public void setSnapshotSegments(List<TherapySegment> snapshotSegments) {
    this.snapshotSegments = snapshotSegments;
  }

  public ProfileSnapshotHistoryResponse changeSource(com.diacore.domain.profile.model.ChangeSource changeSource) {
    this.changeSource = changeSource;
    return this;
  }

  /**
   * Get changeSource
   * @return changeSource
  */
  @NotNull
  @JsonProperty("changeSource")
  public com.diacore.domain.profile.model.ChangeSource getChangeSource() {
    return changeSource;
  }

  public void setChangeSource(com.diacore.domain.profile.model.ChangeSource changeSource) {
    this.changeSource = changeSource;
  }

  public ProfileSnapshotHistoryResponse reasonText(String reasonText) {
    this.reasonText = reasonText;
    return this;
  }

  /**
   * 변경 상세 사유 (선택)
   * @return reasonText
  */
  
  @JsonProperty("reasonText")
  public String getReasonText() {
    return reasonText;
  }

  public void setReasonText(String reasonText) {
    this.reasonText = reasonText;
  }

  public ProfileSnapshotHistoryResponse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * 해당 스냅샷이 기록된 일시
   * @return createdAt
  */
  @NotNull
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfileSnapshotHistoryResponse profileSnapshotHistoryResponse = (ProfileSnapshotHistoryResponse) o;
    return Objects.equals(this.snapshotSegments, profileSnapshotHistoryResponse.snapshotSegments) &&
        Objects.equals(this.changeSource, profileSnapshotHistoryResponse.changeSource) &&
        Objects.equals(this.reasonText, profileSnapshotHistoryResponse.reasonText) &&
        Objects.equals(this.createdAt, profileSnapshotHistoryResponse.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(snapshotSegments, changeSource, reasonText, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfileSnapshotHistoryResponse {\n");
    sb.append("    snapshotSegments: ").append(toIndentedString(snapshotSegments)).append("\n");
    sb.append("    changeSource: ").append(toIndentedString(changeSource)).append("\n");
    sb.append("    reasonText: ").append(toIndentedString(reasonText)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

