package nba.stats.predict.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerProfile {

  @Id
  @GeneratedValue
  @JsonProperty(access = Access.READ_ONLY)
  private Integer id;

  private String playerName;

  private Double season;

  private Double points;

  private String team;

  private Double totalRb;

  private Double assists;

}
