package edu.cnm.deepdive.counter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainController {


  @FXML
  private Text count;

  @FXML
  private Button increment;

  @FXML
  private Button reset;

  private int tally;

  @FXML
  private void incrementTally(ActionEvent actionEvent) {
    updateTally(tally + 1);
  }

  @FXML
  private void resetTally(ActionEvent actionEvent) {
    updateTally(0);
  }


  private void updateTally(int value) {
    tally = value;
    count.setText(String.valueOf(tally));
  }

}
