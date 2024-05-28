package edu.cnm.deepdive.counter;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  private static final String BUNDLE_NAME = "ui-strings";
  private static final String LAYOUT_FILE = "main.fxml";
  private static final String TITLE_KEY = "title";

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    FXMLLoader loader = new FXMLLoader(getClass().getResource(LAYOUT_FILE), bundle);
    Scene scene = new Scene(loader.load());
    //// TODO: 5/28/24 Get reference to controller.
    stage.setTitle(bundle.getString(TITLE_KEY));
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
  }

}


