package nba.stats.predict.service;

import java.util.List;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nba.stats.predict.models.PlayerPredictions;
import nba.stats.predict.models.PlayerProfile;
import nba.stats.predict.repository.PredictionsRepository;

@Component
public class PlayerService {

  @Autowired
  private PredictionsRepository predictionsRepository;

  public List<PlayerPredictions> getAllMyPlayersPredictions(Integer userId, int page, int pageSize) {

    return predictionsRepository.findAllByUserId(userId, page, pageSize);
  }

  /**
   * Predict next season's performance of a player given player's career history
   * 
   * @param profiles
   * @param userId
   * @return Object contiaing a player's predictions for next season
   */
  public PlayerPredictions makePredictions(List<PlayerProfile> profiles, Integer userId) {

    SimpleRegression pointRegression = new SimpleRegression();
    SimpleRegression asstRegression = new SimpleRegression();
    SimpleRegression rebRegression = new SimpleRegression();

    for (PlayerProfile profile : profiles) {
      pointRegression.addData(Double.valueOf(profile.getSeason()), Double.valueOf(profile.getPoints()));
      asstRegression.addData(Double.valueOf(profile.getSeason()), Double.valueOf(profile.getAssists()));
      rebRegression.addData(Double.valueOf(profile.getSeason()), Double.valueOf(profile.getTotalRb()));

    }

    PlayerPredictions prediction = new PlayerPredictions()
        .withUserId(userId)
        .withPlayerName(profiles.get(0).getPlayerName())
        .withLastSeasonPoints(profiles.get(profiles.size() - 1).getPoints())
        .withPredictedPoints(pointRegression.predict(Double.valueOf(2025)))
        .withPredictedAssists(asstRegression.predict(2025)).withPredictedRebounds(rebRegression.predict(2025));

    predictionsRepository.save(prediction);

    return prediction;

  }

  public Integer deletePredictionById(Integer id) {
    predictionsRepository.deleteById(id);
    return id;
  }

}
