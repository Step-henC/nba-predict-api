package nba.stats.predict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nba.stats.predict.models.PlayerPredictions;

public interface PredictionsRepository extends JpaRepository<PlayerPredictions, Integer> {

  @Query(value = "SELECT * FROM player_predictions pp WHERE pp.user_id = :userId LIMIT :pageSize OFFSET :page", nativeQuery = true)
  List<PlayerPredictions> findAllByUserId(
      @Param("userId") Integer userId,
      @Param("page") int page,
      @Param("pageSize") int pageSize

  );

}
