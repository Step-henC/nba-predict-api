package nba.stats.predict.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // allow all origins
public class BaseController {

  @GetMapping("/")
  public String greeting() {
    return "Predict Stats App API Server 2024";
  }

}
