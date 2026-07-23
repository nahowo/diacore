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
 * MealLogResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-23T17:25:14.259910+09:00[Asia/Seoul]", comments = "Generator version: 7.5.0")
public class MealLogResponse {

  private Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Float carbohydrateG = null;

  private String mealType;

  private String foodDesc;

  public MealLogResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MealLogResponse(Long id, OffsetDateTime timestamp, Float carbohydrateG, String mealType) {
    this.id = id;
    this.timestamp = timestamp;
    this.carbohydrateG = carbohydrateG;
    this.mealType = mealType;
  }

  public MealLogResponse id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MealLogResponse timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
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

  public MealLogResponse carbohydrateG(Float carbohydrateG) {
    this.carbohydrateG = carbohydrateG;
    return this;
  }

  /**
   * Get carbohydrateG
   * @return carbohydrateG
  */
  @NotNull
  @JsonProperty("carbohydrateG")
  public Float getCarbohydrateG() {
    return carbohydrateG;
  }

  public void setCarbohydrateG(Float carbohydrateG) {
    this.carbohydrateG = carbohydrateG;
  }

  public MealLogResponse mealType(String mealType) {
    this.mealType = mealType;
    return this;
  }

  /**
   * Get mealType
   * @return mealType
  */
  @NotNull
  @JsonProperty("mealType")
  public String getMealType() {
    return mealType;
  }

  public void setMealType(String mealType) {
    this.mealType = mealType;
  }

  public MealLogResponse foodDesc(String foodDesc) {
    this.foodDesc = foodDesc;
    return this;
  }

  /**
   * Get foodDesc
   * @return foodDesc
  */
  
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
    MealLogResponse mealLogResponse = (MealLogResponse) o;
    return Objects.equals(this.id, mealLogResponse.id) &&
        Objects.equals(this.timestamp, mealLogResponse.timestamp) &&
        Objects.equals(this.carbohydrateG, mealLogResponse.carbohydrateG) &&
        Objects.equals(this.mealType, mealLogResponse.mealType) &&
        Objects.equals(this.foodDesc, mealLogResponse.foodDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timestamp, carbohydrateG, mealType, foodDesc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealLogResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

