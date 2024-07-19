package nba.stats.predict.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
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
@With
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profile")
public class UserProfile {

  @Id
  @GeneratedValue
  @JsonProperty(access = Access.READ_ONLY)
  private Integer id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "password")
  private String password;

}
