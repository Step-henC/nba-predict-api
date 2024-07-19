package nba.stats.predict.controllers;

import org.springframework.web.bind.annotation.RestController;

import nba.stats.predict.models.UserProfile;
import nba.stats.predict.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("new-user")
  public UserProfile createUser(@RequestBody UserProfile user) {

    return service.createUser(user);

  }

  @PostMapping("user")
  public UserProfile getUser(@RequestBody UserProfile user) {

    return service.getUser(user);

  }

}
