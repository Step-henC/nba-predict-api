package nba.stats.predict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nba.stats.predict.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

  @Query(value = "SELECT * FROM user_profile u WHERE u.user_name = :userName AND u.password = :password LIMIT 1", nativeQuery = true)
  UserProfile findByUserNameAndPassword(
      @Param("userName") String userName,
      @Param("password") String password);

}
