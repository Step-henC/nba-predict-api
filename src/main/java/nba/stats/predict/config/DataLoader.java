package nba.stats.predict.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nba.stats.predict.models.PlayerPredictions;
import nba.stats.predict.models.UserProfile;
import nba.stats.predict.repository.PredictionsRepository;
import nba.stats.predict.repository.UserProfileRepository;

@Component
public class DataLoader implements CommandLineRunner {

  private final UserProfileRepository userRepository;

  private final PredictionsRepository predictionsRepository;

  public DataLoader(UserProfileRepository repo, PredictionsRepository pred) {
    this.userRepository = repo;
    this.predictionsRepository = pred;
  }

  @Override
  public void run(String... args) throws Exception {
    UserProfile user = userRepository.save(new UserProfile().withUserName("test").withPassword("test"));

    predictionsRepository.save(new PlayerPredictions()
        .withPlayerName("Mock Player")
        .withUserId(user.getId())
        .withPredictedPoints(Double.valueOf(322))
        .withLastSeasonPoints(Double.valueOf(211))
        .withPredictedRebounds(Double.valueOf(111))
        .withPredictedAssists(Double.valueOf(221)));

  }

}
