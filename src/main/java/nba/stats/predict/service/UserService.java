package nba.stats.predict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nba.stats.predict.models.UserProfile;
import nba.stats.predict.repository.UserProfileRepository;

@Component
public class UserService {

  @Autowired
  UserProfileRepository repository;

  public UserProfile createUser(UserProfile user) {

    return repository.save(user);
  }

  public UserProfile getUser(UserProfile user) {
    return repository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
  }

}
