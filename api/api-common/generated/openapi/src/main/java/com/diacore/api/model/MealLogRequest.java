package com.diacore.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * MealLogRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-26T17:35:52.036281+09:00[Asia/Seoul]")
public class MealLogRequest {

  private Long userId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Integer carbohydrateG;

  private String mealType;

  private String foodDesc;

  public MealLogRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MealLogRequest(Long userId, OffsetDateTime timestamp, Integer carbohydrateG, String mealType) {
    this.userId = userId;
    this.timestamp = timestamp;
    this.carbohydrateG = carbohydrateG;
    this.mealType = mealType;
  }

  public MealLogRequest userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public MealLogRequest timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  */
  @NotNull @Valid 
  @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public MealLogRequest carbohydrateG(Integer carbohydrateG) {
    this.carbohydrateG = carbohydrateG;
    return this;
  }

  /**
   * carb (g)
   * @return carbohydrateG
  */
  @NotNull 
  @Schema(name = "carbohydrateG", description = "carb (g)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("carbohydrateG")
  public Integer getCarbohydrateG() {
    return carbohydrateG;
  }

  public void setCarbohydrateG(Integer carbohydrateG) {
    this.carbohydrateG = carbohydrateG;
  }

  public MealLogRequest mealType(String mealType) {
    this.mealType = mealType;
    return this;
  }

  /**
   * Get mealType
   * @return mealType
  */
  @NotNull 
  @Schema(name = "mealType", example = "BREAKFAST", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mealType")
  public String getMealType() {
    return mealType;
  }

  public void setMealType(String mealType) {
    this.mealType = mealType;
  }

  public MealLogRequest foodDesc(String foodDesc) {
    this.foodDesc = foodDesc;
    return this;
  }

  /**
   * Get foodDesc
   * @return foodDesc
  */
  
  @Schema(name = "foodDesc", example = "사과 1개", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("foodDesc")
  public String getFoodDesc() {
    return foodDesc;
  }

  public void setFoodDesc(String foodDesc) {
    this.foodDesc = foodDesc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MealLogRequest mealLogRequest = (MealLogRequest) o;
    return Objects.equals(this.userId, mealLogRequest.userId) &&
        Objects.equals(this.timestamp, mealLogRequest.timestamp) &&
        Objects.equals(this.carbohydrateG, mealLogRequest.carbohydrateG) &&
        Objects.equals(this.mealType, mealLogRequest.mealType) &&
        Objects.equals(this.foodDesc, mealLogRequest.foodDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, timestamp, carbohydrateG, mealType, foodDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealLogRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    carbohydrateG: ").append(toIndentedString(carbohydrateG)).append("\n");
    sb.append("    mealType: ").append(toIndentedString(mealType)).append("\n");
    sb.append("    foodDesc: ").append(toIndentedString(foodDesc)).append("\n");
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

