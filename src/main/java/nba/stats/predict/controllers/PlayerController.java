package nba.stats.predict.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import nba.stats.predict.models.PlayerPredictions;
import nba.stats.predict.models.PlayerProfile;
import nba.stats.predict.service.PlayerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  @GetMapping("players/{userId}")
  public List<PlayerPredictions> getAllMyPlayers(@PathVariable("userId") Integer userId,
      @RequestParam(defaultValue = "0", required = false) int page,
      @RequestParam(defaultValue = "5", required = false) int pageSize) {

    int offsetValue = page * 3;

    return playerService.getAllMyPlayersPredictions(userId, offsetValue, pageSize);
  }

  @PostMapping("add-prediction/{userId}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Created Player Prediction"),
      @ApiResponse(responseCode = "400", description = "Need 3 or more observations")
  })
  public ResponseEntity<PlayerPredictions> addPlayerPrediction(@PathVariable("userId") Integer userId,
      @RequestBody List<PlayerProfile> entity) {

    // Simple Regression needs more than two observations otherwise NaN
    if (entity.size() <= 2 || entity == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    PlayerPredictions prediction = playerService.makePredictions(entity, userId);

    return new ResponseEntity<>(prediction, null, HttpStatus.CREATED);
  }

  /*
   * Creating this to make predictions without users. Not needed for AWS Lambda fn
   * Eventually remove user logic
   * 
   */

  @PostMapping("add-prediction")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Created Player Prediction"),
      @ApiResponse(responseCode = "400", description = "Need 3 or more observations")
  })
  public ResponseEntity<PlayerPredictions> createPlayerPrediction(@PathVariable("userId") Integer userId,
      @RequestBody List<PlayerProfile> entity) {

    // Simple Regression needs more than two observations otherwise NaN
    if (entity.size() <= 2 || entity == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    PlayerPredictions prediction = playerService.makePredictions(entity, userId);

    return new ResponseEntity<>(prediction, null, HttpStatus.CREATED);
  }

  @DeleteMapping("delete/{id}")
  public Integer deletePlayerPrediction(@PathVariable("id") Integer predictionId) {

    return playerService.deletePredictionById(predictionId);
  }

}
