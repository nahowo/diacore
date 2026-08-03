package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.diacore.api.model.PredictionTrajectoryPoint;
import com.diacore.api.model.RecommendedAction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GlucoseSimulationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-31T08:39:54.111124+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class GlucoseSimulationResponse {

  private String reason;

  private Integer eventualBg;

  private Integer snoozeBg;

  private RecommendedAction recommendedAction;

  
  private List<PredictionTrajectoryPoint> trajectories = new ArrayList<>();

  public GlucoseSimulationResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GlucoseSimulationResponse(String reason, Integer eventualBg, List<PredictionTrajectoryPoint> trajectories) {
    this.reason = reason;
    this.eventualBg = eventualBg;
    this.trajectories = trajectories;
  }

  public GlucoseSimulationResponse reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * OpenAPS Reason
   * @return reason
  */
  @NotNull
  @JsonProperty("reason")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public GlucoseSimulationResponse eventualBg(Integer eventualBg) {
    this.eventualBg = eventualBg;
    return this;
  }

  /**
   * IOB와 COB가 모두 소모된 후 도달할 최종 예상 혈당
   * @return eventualBg
  */
  @NotNull
  @JsonProperty("eventualBg")
  public Integer getEventualBg() {
    return eventualBg;
  }

  public void setEventualBg(Integer eventualBg) {
    this.eventualBg = eventualBg;
  }

  public GlucoseSimulationResponse snoozeBg(Integer snoozeBg) {
    this.snoozeBg = snoozeBg;
    return this;
  }

  /**
   * 단기적 과잉 교정을 막기 위한 참고 혈당
   * @return snoozeBg
  */
  
  @JsonProperty("snoozeBg")
  public Integer getSnoozeBg() {
    return snoozeBg;
  }

  public void setSnoozeBg(Integer snoozeBg) {
    this.snoozeBg = snoozeBg;
  }

  public GlucoseSimulationResponse recommendedAction(RecommendedAction recommendedAction) {
    this.recommendedAction = recommendedAction;
    return this;
  }

  /**
   * Get recommendedAction
   * @return recommendedAction
  */
  
  @JsonProperty("recommendedAction")
  public RecommendedAction getRecommendedAction() {
    return recommendedAction;
  }

  public void setRecommendedAction(RecommendedAction recommendedAction) {
    this.recommendedAction = recommendedAction;
  }

  public GlucoseSimulationResponse trajectories(List<PredictionTrajectoryPoint> trajectories) {
    this.trajectories = trajectories;
    return this;
  }

  public GlucoseSimulationResponse addTrajectoriesItem(PredictionTrajectoryPoint trajectoriesItem) {
    if (this.trajectories == null) {
      this.trajectories = new ArrayList<>();
    }
    this.trajectories.add(trajectoriesItem);
    return this;
  }

  /**
   * 시간(5분 단위)에 따른 다중 예측 곡선 포인트 리스트
   * @return trajectories
  */
  @NotNull
  @JsonProperty("trajectories")
  public List<PredictionTrajectoryPoint> getTrajectories() {
    return trajectories;
  }

  public void setTrajectories(List<PredictionTrajectoryPoint> trajectories) {
    this.trajectories = trajectories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlucoseSimulationResponse glucoseSimulationResponse = (GlucoseSimulationResponse) o;
    return Objects.equals(this.reason, glucoseSimulationResponse.reason) &&
        Objects.equals(this.eventualBg, glucoseSimulationResponse.eventualBg) &&
        Objects.equals(this.snoozeBg, glucoseSimulationResponse.snoozeBg) &&
        Objects.equals(this.recommendedAction, glucoseSimulationResponse.recommendedAction) &&
        Objects.equals(this.trajectories, glucoseSimulationResponse.trajectories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, eventualBg, snoozeBg, recommendedAction, trajectories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlucoseSimulationResponse {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    eventualBg: ").append(toIndentedString(eventualBg)).append("\n");
    sb.append("    snoozeBg: ").append(toIndentedString(snoozeBg)).append("\n");
    sb.append("    recommendedAction: ").append(toIndentedString(recommendedAction)).append("\n");
    sb.append("    trajectories: ").append(toIndentedString(trajectories)).append("\n");
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

