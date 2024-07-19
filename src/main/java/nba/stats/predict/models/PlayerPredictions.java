package nba.stats.predict.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player_predictions")
public class PlayerPredictions {

  @Id
  @GeneratedValue
  @JsonProperty(access = Access.READ_ONLY)
  private Integer id;

  private String playerName;

  private Double lastSeasonPoints;

  private Double predictedPoints;

  private Double predictedRebounds;

  private Double predictedAssists;

  @JsonIgnore
  private Integer userId;

}
