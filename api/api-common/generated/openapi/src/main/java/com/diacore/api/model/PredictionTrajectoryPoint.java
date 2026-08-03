package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PredictionTrajectoryPoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-31T08:39:54.111124+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class PredictionTrajectoryPoint {

  private Integer offsetMinutes;

  private Integer iobPred;

  private Integer cobPred;

  private Integer zeroTempPred;

  private Integer uamPred;

  private Integer simulatedPred;

  public PredictionTrajectoryPoint() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PredictionTrajectoryPoint(Integer offsetMinutes) {
    this.offsetMinutes = offsetMinutes;
  }

  public PredictionTrajectoryPoint offsetMinutes(Integer offsetMinutes) {
    this.offsetMinutes = offsetMinutes;
    return this;
  }

  /**
   * 현재 시점으로부터의 경과 시간 (보통 5분 단위)
   * @return offsetMinutes
  */
  @NotNull
  @JsonProperty("offsetMinutes")
  public Integer getOffsetMinutes() {
    return offsetMinutes;
  }

  public void setOffsetMinutes(Integer offsetMinutes) {
    this.offsetMinutes = offsetMinutes;
  }

  public PredictionTrajectoryPoint iobPred(Integer iobPred) {
    this.iobPred = iobPred;
    return this;
  }

  /**
   * IOB 기반 예측 수치 (인슐린만 작용할 때)
   * @return iobPred
  */
  
  @JsonProperty("iobPred")
  public Integer getIobPred() {
    return iobPred;
  }

  public void setIobPred(Integer iobPred) {
    this.iobPred = iobPred;
  }

  public PredictionTrajectoryPoint cobPred(Integer cobPred) {
    this.cobPred = cobPred;
    return this;
  }

  /**
   * COB 기반 예측 수치 (남은 탄수화물 흡수 시)
   * @return cobPred
  */
  
  @JsonProperty("cobPred")
  public Integer getCobPred() {
    return cobPred;
  }

  public void setCobPred(Integer cobPred) {
    this.cobPred = cobPred;
  }

  public PredictionTrajectoryPoint zeroTempPred(Integer zeroTempPred) {
    this.zeroTempPred = zeroTempPred;
    return this;
  }

  /**
   * 인슐린 주입 완전 중단(Zero-temp) 시 예상 수치
   * @return zeroTempPred
  */
  
  @JsonProperty("zeroTempPred")
  public Integer getZeroTempPred() {
    return zeroTempPred;
  }

  public void setZeroTempPred(Integer zeroTempPred) {
    this.zeroTempPred = zeroTempPred;
  }

  public PredictionTrajectoryPoint uamPred(Integer uamPred) {
    this.uamPred = uamPred;
    return this;
  }

  /**
   * 미식별 활동(UAM) 감지 시 예측 수치
   * @return uamPred
  */
  
  @JsonProperty("uamPred")
  public Integer getUamPred() {
    return uamPred;
  }

  public void setUamPred(Integer uamPred) {
    this.uamPred = uamPred;
  }

  public PredictionTrajectoryPoint simulatedPred(Integer simulatedPred) {
    this.simulatedPred = simulatedPred;
    return this;
  }

  /**
   * 사용자가 입력한 식사/인슐린/운동 시나리오를 반영한 최종 시뮬레이션 예측 수치
   * @return simulatedPred
  */
  
  @JsonProperty("simulatedPred")
  public Integer getSimulatedPred() {
    return simulatedPred;
  }

  public void setSimulatedPred(Integer simulatedPred) {
    this.simulatedPred = simulatedPred;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PredictionTrajectoryPoint predictionTrajectoryPoint = (PredictionTrajectoryPoint) o;
    return Objects.equals(this.offsetMinutes, predictionTrajectoryPoint.offsetMinutes) &&
        Objects.equals(this.iobPred, predictionTrajectoryPoint.iobPred) &&
        Objects.equals(this.cobPred, predictionTrajectoryPoint.cobPred) &&
        Objects.equals(this.zeroTempPred, predictionTrajectoryPoint.zeroTempPred) &&
        Objects.equals(this.uamPred, predictionTrajectoryPoint.uamPred) &&
        Objects.equals(this.simulatedPred, predictionTrajectoryPoint.simulatedPred);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offsetMinutes, iobPred, cobPred, zeroTempPred, uamPred, simulatedPred);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PredictionTrajectoryPoint {\n");
    sb.append("    offsetMinutes: ").append(toIndentedString(offsetMinutes)).append("\n");
    sb.append("    iobPred: ").append(toIndentedString(iobPred)).append("\n");
    sb.append("    cobPred: ").append(toIndentedString(cobPred)).append("\n");
    sb.append("    zeroTempPred: ").append(toIndentedString(zeroTempPred)).append("\n");
    sb.append("    uamPred: ").append(toIndentedString(uamPred)).append("\n");
    sb.append("    simulatedPred: ").append(toIndentedString(simulatedPred)).append("\n");
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

